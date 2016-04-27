package model;

public class Course {
	String courseNumber;
	String courseTitle;
	double credits;
	double grade;
	
	public Course(String courseNumber, String courseTitle, double credits, double grade) {
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.credits = credits;
		this.grade = grade;
	}
	public Course(String courseNumber, String courseTitle, double credits) {
		this.courseNumber = courseNumber;
		this.courseTitle = courseTitle;
		this.credits = credits;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
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
	
	public Course copy(double grade){//courses are copied when they are assigned to a student. Each student will recieve a grade
		Course c2 = new Course(this.courseNumber, this.courseTitle, this.credits, grade);
		return c2;
	}
	@Override
	public String toString(){
		if(grade != 0){
			return "\n" + courseTitle + " Credits: " + credits + " Grade: " + grade;
		}else {
			return "\n" + courseTitle + " Credits: " + credits;
		}
		
	}
	
	
	

}
