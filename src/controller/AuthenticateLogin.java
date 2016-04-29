package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Account;
import model.AccountBag;
import model.Admin;
import model.ModelFacade;
import model.Student;
import model.Teacher;
import view.IGoToWhatIfListener;
import view.ILoginListener;
import view.ILogoutListener;
import view.IWhatIfListener;
import view.LoginEvent;
import view.LoginView;
import view.StudentView;
import view.WhatIfEvent;
import view.WhatIfView;

public class AuthenticateLogin {
	Stage stage;
	SortStudentsCourses cs = new SortStudentsCourses();
	
	public AuthenticateLogin(Stage stage){
		this.stage = stage;
	}
	
	public void tryLogin(String username, String ID){
		
		AccountBag studentBag = null;
		AccountBag teacherBag = null;
		AccountBag adminBag = null;
		
		try{
			ObjectInputStream StudentOS = new ObjectInputStream(new FileInputStream(new File("C://Users/Randy/workspace/The Sain Report/src/Database/Students.bin")));
			//studentBag = (AccountBag) StudentOS.readObject();
			studentBag = new ModelFacade().getStudentBag();//using model facade because the first student has no major
			ObjectInputStream teacherOS = new ObjectInputStream(new FileInputStream(new File("C://Users/Randy/workspace/The Sain Report/src/Database/Faculty.bin")));
			teacherBag = (AccountBag) teacherOS.readObject();
			
			ObjectInputStream adminOS = new ObjectInputStream(new FileInputStream(new File("C://Users/Randy/workspace/The Sain Report/src/Database/Administrators.bin")));
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
				stage.setScene(new Scene(wv.getPane()));//to be handled by the controller
				stage.setHeight(300);
				stage.setWidth(300);
				stage.centerOnScreen();
			}
			
		}else if(teacherBag.bag.containsKey(ID)){
			teacherBag.bag.get(ID);//TODO
			
		}else if(adminBag.bag.containsKey(ID)){
			adminBag.bag.get(ID);
		}
		
	}
	
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

}
