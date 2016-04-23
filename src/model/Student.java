package model;

import java.util.ArrayList;

public class Student implements Account{
	String name;
	String username;
	String ID;
	String majorID;
	double gpa;
	static final int permissionLevel = 1;
	
	ArrayList<Course> coursesCompleted;
	ArrayList<Course> coursesFailed;
	ArrayList<Course> coursesInProgress;
	
	public Student(String name, String username, String ID, String majorID, double gpa,
			ArrayList<Course> coursesCompleted, ArrayList<Course> coursesFailed, ArrayList<Course> coursesInProgress) {
		this.name = name;
		this.username = username;
		this.ID = ID;
		this.majorID = majorID;
		this.gpa = gpa;
		this.coursesCompleted = coursesCompleted;
		this.coursesFailed = coursesFailed;
		this.coursesInProgress = coursesInProgress;
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

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getPermissionLevel() {
		return permissionLevel;
	}

	public ArrayList<Course> getCoursesCompleted() {
		return coursesCompleted;
	}

	public ArrayList<Course> getCoursesFailed() {
		return coursesFailed;
	}

	public ArrayList<Course> getCoursesInProgress() {
		return coursesInProgress;
	}

}
