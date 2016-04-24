package model;

import java.util.ArrayList;

public class Student implements Account{
	String name;
	String username;
	String ID;
	String majorID;
	double gpa;
	static final int permissionLevel = 1;
	
	Course[] coursesCompleted;
	Course[] coursesFailed;
	Course[] coursesInProgress;
	
	public Student(String name, String username, String ID, String majorID, double gpa,
			Course[] coursesCompleted, Course[] coursesFailed, Course[] coursesInProgress) {
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
	
	public Major getMajor() {
		return MajorBag.bag.get(majorID);
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

	public Course[] getCoursesCompleted() {
		return coursesCompleted;
	}

	public Course[] getCoursesFailed() {
		return coursesFailed;
	}

	public Course[] getCoursesInProgress() {
		return coursesInProgress;
	}

}
