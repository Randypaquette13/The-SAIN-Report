package model;

public class Major {
	String title;
	String MajorID;
	
	Course[] majorCourses;
	Course[] engCourses;
	Course[] sciCourses;
	Course[] matCourses;
	Course[] sscCourses;
	Course[] humCourses;
	
	public Major(String title, String majorID, Course[] majorCourses, Course[] engCourses, Course[] sciCourses,
			Course[] matCourses, Course[] sscCourses, Course[] humCourses) {
		this.title = title;
		MajorID = majorID;
		this.majorCourses = majorCourses;
		this.engCourses = engCourses;
		this.sciCourses = sciCourses;
		this.matCourses = matCourses;
		this.sscCourses = sscCourses;
		this.humCourses = humCourses;
	}

	public String getTitle() {
		return title;
	}

	public String getMajorID() {
		return MajorID;
	}

	public Course[] getMajorCourses() {
		return majorCourses;
	}

	public Course[] getEngCourses() {
		return engCourses;
	}

	public Course[] getSciCourses() {
		return sciCourses;
	}

	public Course[] getMatCourses() {
		return matCourses;
	}

	public Course[] getSscCourses() {
		return sscCourses;
	}

	public Course[] getHumCourses() {
		return humCourses;
	}
	
	

}
