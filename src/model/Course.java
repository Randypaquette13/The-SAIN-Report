package model;

public class Course {
	String courseNumber;
	String courseTitle;
	double credits;
	String grade;
	
	public Course(String courseNumber, String courseTitle, double credits) {
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.credits = credits;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public double getCredits() {
		return credits;
	}
	
	

}
