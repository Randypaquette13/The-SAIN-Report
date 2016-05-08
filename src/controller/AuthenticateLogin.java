package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Account;
import model.AccountBag;
import model.Admin;
import model.ModelFacade;
import model.Student;
import model.Teacher;
import view.ChangeStudentsGradesView;
import view.IGoToWhatIfListener;
import view.ILoginListener;
import view.ILogoutListener;
import view.ISearchListener;
import view.IUpdateGradesListener;
import view.IWhatIfListener;
import view.LoginEvent;
import view.LoginView;
import view.SearchEvent;
import view.SearchView;
import view.StudentView;
import view.UpdateGradesEvent;
import view.WhatIfEvent;
import view.WhatIfView;
/**
 * class to handle authentication and the viewing of StudentView
 * @author Randy Paquette
 *
 */
public class AuthenticateLogin {
	Stage stage;
	SortStudentsCourses cs = new SortStudentsCourses();
	
	public AuthenticateLogin(Stage stage){
		this.stage = stage;
	}
	
	/**
	 * 
	 * @param username the input username of the student/teacher/admin
	 * @param ID       the ID
	 */
	public void tryLogin(String username, String ID){
		
		AccountBag studentBag = null;
		AccountBag teacherBag = null;
		AccountBag adminBag = null;
		
		try{
			ObjectInputStream StudentOS = new ObjectInputStream(new FileInputStream(new File("Database/Students.bin")));
			studentBag = (AccountBag) StudentOS.readObject();
			ObjectInputStream teacherOS = new ObjectInputStream(new FileInputStream(new File("Database/Faculty.bin")));
			teacherBag = (AccountBag) teacherOS.readObject();
			ObjectInputStream adminOS = new ObjectInputStream(new FileInputStream(new File("Database/Administrators.bin")));
			adminBag = (AccountBag) adminOS.readObject();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		if(studentBag.bag.containsKey(ID)){//case:Student
			Student s = (Student) studentBag.bag.get(ID);
			
			if(s.getMajorID() != null){
				setUpStudentView(s);
			}else{
				WhatIfView wv = new WhatIfView(new IWhatIfListener() {
					
					@Override
					public void getMajorID(WhatIfEvent wie) {
						s.setMajorID(wie.getMajorID());
						setUpStudentView(s);
					}
				});
				stage.setScene(new Scene(wv.getPane()));
				stage.setHeight(300);
				stage.setWidth(300);
				stage.centerOnScreen();
			}
			
		}else if(teacherBag.bag.containsKey(ID)){
			Teacher t = (Teacher) teacherBag.bag.get(ID);
			AccountBag ab = studentBag;
			SearchView sev = new SearchView(new ISearchListener() {
				
				@Override
				public String search(SearchEvent e) {
					
					return foundStudentFromTeacher(e.getStudentID(), t);
				}
			});
			stage.setScene(new Scene(sev.getPane()));
			stage.setHeight(200);
			stage.setWidth(300);
			stage.centerOnScreen();
			
		}else if(adminBag.bag.containsKey(ID)){
			Admin a = (Admin) adminBag.bag.get(ID);
			SearchView sev = new SearchView(new ISearchListener() {
				
				@Override
				public String search(SearchEvent e) {
					
					return foundStudentFromAdmin(e.getStudentID());
				}
			});
			stage.setScene(new Scene(sev.getPane()));//to be handled by the controller
			stage.setHeight(200);
			stage.setWidth(300);
			stage.centerOnScreen();
		}
		
	}
	/**
	 * helps set up a Student View
	 * 
	 * @param s student to generate a sain report for
	 */
	public void setUpStudentView(Student s){
		StudentView sv = new StudentView(s.getName(), ("ID: " + s.getID()), s.getMajor().toString(), String.valueOf("Gpa: " + s.getGpa()), 
				cs.coursesTakenInMajor(s), cs.coursesTakenNotInMajor(s), cs.coursesFailed(s), cs.CoursesInProgress(s), cs.majorCoursesNeeded(s), 
				cs.englishCoursesNeeded(s), cs.scienceCoursesNeeded(s), cs.mathCoursesNeeded(s), cs.socialScienceCoursesNeeded(s), 
				cs.humanitiesNeeded(s), String.valueOf(cs.totalCreditsTaken(s)), String.valueOf(cs.totalCreditsRequired(s)), String.valueOf(cs.totalCreditsNeeded(s)));
		sv.setLogoutListener(new ILogoutListener() {
			
			@Override
			public void logout() {
				AuthenticateLogin auth = new AuthenticateLogin(stage);
				LoginView lv = new LoginView(new ILoginListener() {
					
					@Override
					public void getLoginDetails(LoginEvent e) {
						auth.tryLogin(e.getUsername(), e.getID());
					}
				});
				stage.setScene(new Scene(lv.getPane()));
				stage.setHeight(340);
				stage.setWidth(654);
				stage.centerOnScreen();
			}
		});
		sv.setGoToWhatIfListener(new IGoToWhatIfListener() {
			
			@Override
			public void goToWhatIf() {
				WhatIfView wv = new WhatIfView(new IWhatIfListener() {
					
					@Override
					public void getMajorID(WhatIfEvent wie) {
						s.setMajorID(wie.getMajorID());
						setUpStudentView(s);
					}
				});
				stage.setScene(new Scene(wv.getPane()));
				stage.setHeight(300);
				stage.setWidth(300);
				stage.centerOnScreen();
				
			}
		});
		stage.setScene(new Scene(sv.getPane()));//to be handled by the controller
		stage.setHeight(900);
		stage.setWidth(1000);
		stage.centerOnScreen();
	}
	
	/**
	 * Method to be called in the search event listener
	 * 
	 * @param ID students ID
	 * @return   returns a string only to report an error
	 */
	public String foundStudentFromAdmin(String ID){
		AccountBag studentBag = null;
		
		try{
			ObjectInputStream StudentOS = new ObjectInputStream(new FileInputStream(new File("Database/Students.bin")));
			studentBag = (AccountBag) StudentOS.readObject();

		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(studentBag.bag.containsKey(ID)){
			Student s = (Student) studentBag.bag.get(ID);
			AccountBag sb = studentBag;
			ChangeStudentsGradesView csgv = new ChangeStudentsGradesView(cs.CoursesInProgressStringArray(s), new IUpdateGradesListener() {
				
				@Override
				public String getGrades(UpdateGradesEvent uge) {
					boolean validEntry = true;
					
					for(int i = 0; i < uge.getGrades().length; i++){
						if(uge.getGrades()[i] == -50){
							validEntry = false;
							return "enter valid grades for each field";
						}
					}
					if(validEntry){
						for(int i = 0; i < s.getCoursesInProgress().length; i++){
							s.getCoursesInProgress()[i].setGrade(uge.getGrades()[i]);//write this student to binary
							sb.bag.put(ID, s);
							try {
								ObjectOutputStream StudentOS = new ObjectOutputStream(new FileOutputStream(new File("Database/Students.bin")));
								StudentOS.writeObject(sb);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							if(s.getMajorID() != null){
								setUpStudentView(s);
							}else{
								WhatIfView wv = new WhatIfView(new IWhatIfListener() {
									
									@Override
									public void getMajorID(WhatIfEvent wie) {
										s.setMajorID(wie.getMajorID());
										setUpStudentView(s);
									}
								});
								stage.setScene(new Scene(wv.getPane()));
								stage.setHeight(300);
								stage.setWidth(300);
								stage.centerOnScreen();
							}
						}
					}
					return "enter valid grades for each field";
				}
			});
			stage.setScene(new Scene(csgv.getPane()));//to be handled by the controller
			stage.setHeight(900);
			stage.setWidth(600);
			stage.centerOnScreen();
			return "Student exists";
		}else {
			return "Student does not exist";
		}
	}
	
	/**
	 * Method to be called from the search listener
	 * 
	 * @param ID The ID of the Student
	 * @param t  the teacher who has found the student
	 * @return   an error message for the view
	 */
	public String foundStudentFromTeacher(String ID, Teacher t){
		AccountBag studentBag = null;
		
		try{
			ObjectInputStream StudentOS = new ObjectInputStream(new FileInputStream(new File("Database/Students.bin")));
			studentBag = (AccountBag) StudentOS.readObject();

		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(cs.teacherHasStudent((Student) studentBag.bag.get(ID), t) && studentBag.bag.containsKey(ID)){//case:Student
			Student s = (Student) studentBag.bag.get(ID);
			AccountBag sb = studentBag;
			ChangeStudentsGradesView csgv = new ChangeStudentsGradesView(cs.CourseTeacherHasWithStudent(s, t), new IUpdateGradesListener() {
				
				@Override
				public String getGrades(UpdateGradesEvent uge) {
					boolean validEntry = true;
					
					for(int i = 0; i < uge.getGrades().length; i++){
						if(uge.getGrades()[i] == -50){
							validEntry = false;
							return "enter valid grades for each field";
						}
					}
					if(validEntry){
						for(int i = 0; i < s.getCoursesInProgress().length; i++){

							if(s.getCoursesInProgress()[i].getCourseNumber().equals(t.getCourseTaught().getCourseNumber())){
								s.getCoursesInProgress()[i].setGrade(uge.getGrades()[0]);//write this student to binary
								sb.bag.put(ID, s);
								try {
									ObjectOutputStream StudentOS = new ObjectOutputStream(new FileOutputStream(new File("Database/Students.bin")));
									StudentOS.writeObject(sb);
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
							if(s.getMajorID() != null){
								setUpStudentView(s);
							}else{
								WhatIfView wv = new WhatIfView(new IWhatIfListener() {
									
									@Override
									public void getMajorID(WhatIfEvent wie) {
										s.setMajorID(wie.getMajorID());
										setUpStudentView(s);
									}
								});
								stage.setScene(new Scene(wv.getPane()));
								stage.setHeight(300);
								stage.setWidth(300);
								stage.centerOnScreen();
							}
						}
					}
					return "";
				}
			});
			stage.setScene(new Scene(csgv.getPane()));//to be handled by the controller
			stage.setHeight(900);
			stage.setWidth(600);
			stage.centerOnScreen();
			return "Student exists";
		}else {
			return "You do not Teach this student";
		}
	}

}
