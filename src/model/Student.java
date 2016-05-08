package model;

import java.util.ArrayList;
/**
 * Stores the information about each student
 * 
 * @author Randy
 *
 */
public class Student implements Account{
	String name;
	String username;
	String ID;
	String majorID;
	double gpa;
	static final int permissionLevel = Vars.STUDENT_PERMISSION_LEVEL;
	
	Course[] coursesCompleted;
	Course[] coursesFailed;
	Course[] coursesInProgress;
	
	public Student(String name, String username, String ID, String majorID,
			Course[] coursesCompleted, Course[] coursesFailed, Course[] coursesInProgress) {
		this.name = name;
		this.username = username;
		this.ID = ID;
		this.majorID = majorID;
		this.coursesCompleted = coursesCompleted;
		this.coursesFailed = coursesFailed;
		this.coursesInProgress = coursesInProgress;
		calculateGPA();
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}
	
	public String getID() {
		return ID;
	}

	public String getMajorID() {
		return majorID;
	}

	public void setMajorID(String majorID) {
		this.majorID = majorID;
	}
	
	public Major getMajor() {
		return MajorBag.bag.get(majorID);
	}

	public double getGpa() {
		return gpa;
	}

	public int getPermissionLevel() {
		return permissionLevel;
	}

	public Course[] getCoursesCompleted() {
		return coursesCompleted;
	}

	public Course[] getCoursesFailed() {
		return coursesFailed;
	}

	public Course[] getCoursesInProgress() {
		return coursesInProgress;
	}
	/**
	 * Calculates the average gpa
	 */
	public void calculateGPA(){
		double totalScore = 0;
		
		for(int i = 0; i < coursesCompleted.length; i++){
			totalScore += coursesCompleted[i].getGrade();
		}
		for(int i = 0; i < coursesFailed.length; i++){
			totalScore += coursesFailed[i].getGrade();
		}
		
		gpa = totalScore / (coursesCompleted.length + coursesFailed.length);
	}

}
