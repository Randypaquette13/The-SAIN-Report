package controller;

import model.Course;
import model.Student;
import model.Teacher;

/**
 * A helper class to convert a students courses to strings for the view
 * @author Randy
 *
 */
public class SortStudentsCourses {
	
	/**
	 * Find courses taken in a students major
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String coursesTakenInMajor(Student s) {
		Course[] coursesCompleted = s.getCoursesCompleted();
		Course[] coursesInMajor = s.getMajor().getMajorCourses();
		
		String output = "";
		
		for(int i = 0; i < coursesCompleted.length; i++){
			for(int j = 0; j < coursesInMajor.length; j++){
				if(coursesCompleted[i].getCourseNumber().equals(coursesInMajor[j].getCourseNumber())){//if they have identical course numbers, add the course to the output string
					output = output + coursesCompleted[i].toString();
					
				}
			}
		}
		return output;
	}
	/**
	 * Find courses taken not in a students major
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String coursesTakenNotInMajor(Student s) {
		Course[] coursesCompleted = s.getCoursesCompleted();
		Course[] coursesInMajor = s.getMajor().getMajorCourses();
		
		Course[] coursesCompletedNotInMajor = coursesCompleted.clone();
		String output = "";
		
		for(int i = 0; i < coursesCompleted.length; i++){
			for(int j = 0; j < coursesInMajor.length; j++){
				if(coursesCompleted[i].getCourseNumber().equals(coursesInMajor[j].getCourseNumber())){//if they have identical course numbers, take the course out of the array
					coursesCompletedNotInMajor[i] = null;
				}
			}
		}
		for(int i = 0; i < coursesCompletedNotInMajor.length; i++){
			if(coursesCompletedNotInMajor[i] != null){
				output = output + coursesCompletedNotInMajor[i].toString();
			}
		}
		return output;
	}
	/**
	 * Find courses failed
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String coursesFailed(Student s) {
		String output = "";
		
		for(int i = 0; i < s.getCoursesFailed().length; i++) {
			output = output + s.getCoursesFailed()[i].toString();
		}
		return output;
	}
	/**
	 * Find courses in progress
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String CoursesInProgress(Student s) {
		String output = "";
		
		for(int i = 0; i < s.getCoursesInProgress().length; i++) {
			output = output + s.getCoursesInProgress()[i].toString();
		}
		return output;
	}
	/**
	 * Find courses needed in major
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String majorCoursesNeeded(Student s) {
		Course[] coursesCompleted = s.getCoursesCompleted();
		Course[] coursesInMajor = s.getMajor().getMajorCourses();
		
		Course[] coursesInMajorNeeded = coursesInMajor.clone();
		String output = "";
		
		for(int i = 0; i < coursesCompleted.length; i++){
			for(int j = 0; j < coursesInMajor.length; j++){
				if(coursesCompleted[i].getCourseNumber().equals(coursesInMajor[j].getCourseNumber())){
					coursesInMajorNeeded[j] = null;
				}
			}
		}
		for(int i = 0; i < coursesInMajorNeeded.length; i++){
			if(coursesInMajorNeeded[i] != null){
				output = output + coursesInMajorNeeded[i].toString();
			}
		}
		return output;
		
	}
	/**
	 * Find courses needed for english
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String englishCoursesNeeded(Student s) {
		Course[] coursesCompleted = s.getCoursesCompleted();
		Course[] englishCoursesInMajor = s.getMajor().getEngCourses();
		
		Course[] englishCoursesNeeded = englishCoursesInMajor.clone();
		String output = "";
		
		for(int i = 0; i < coursesCompleted.length; i++){
			for(int j = 0; j < englishCoursesInMajor.length; j++){
				if(coursesCompleted[i].getCourseNumber().equals(englishCoursesInMajor[j].getCourseNumber())){
					englishCoursesNeeded[j] = null;
				}
			}
		}
		for(int i = 0; i < englishCoursesNeeded.length; i++){
			if(englishCoursesNeeded[i] != null){
				output = output + englishCoursesNeeded[i].toString();
			}
		}
		return output;
	}
	/**
	 * Find courses needed for science
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String scienceCoursesNeeded(Student s) {
		Course[] coursesCompleted = s.getCoursesCompleted();
		Course[] scienceCoursesInMajor = s.getMajor().getSciCourses();
		
		Course[] scienceCoursesNeeded = scienceCoursesInMajor.clone();
		String output = "";
		
		for(int i = 0; i < coursesCompleted.length; i++){
			for(int j = 0; j < scienceCoursesInMajor.length; j++){
				if(coursesCompleted[i].getCourseNumber().equals(scienceCoursesInMajor[j].getCourseNumber())){
					scienceCoursesNeeded[j] = null;
				}
			}
		}
		for(int i = 0; i < scienceCoursesNeeded.length; i++){
			if(scienceCoursesNeeded[i] != null){
				output = output + scienceCoursesNeeded[i].toString();
			}
		}
		return output;
	}
	/**
	 * Find courses needed for math
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String mathCoursesNeeded(Student s) {
		Course[] coursesCompleted = s.getCoursesCompleted();
		Course[] mathCoursesInMajor = s.getMajor().getMatCourses();
		
		Course[] mathCoursesNeeded = mathCoursesInMajor.clone();
		String output = "";
		
		for(int i = 0; i < coursesCompleted.length; i++){
			for(int j = 0; j < mathCoursesInMajor.length; j++){
				if(coursesCompleted[i].getCourseNumber().equals(mathCoursesInMajor[j].getCourseNumber())){
					mathCoursesNeeded[j] = null;
				}
			}
		}
		for(int i = 0; i < mathCoursesNeeded.length; i++){
			if(mathCoursesNeeded[i] != null){
				output = output + mathCoursesNeeded[i].toString();
			}
		}
		return output;
	}
	/**
	 * Find courses needed for social science
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String socialScienceCoursesNeeded(Student s) {
		Course[] coursesCompleted = s.getCoursesCompleted();
		Course[] socialScienceCoursesInMajor = s.getMajor().getSscCourses();
		
		Course[] socialScienceCoursesNeeded = socialScienceCoursesInMajor.clone();
		String output = "";
		
		for(int i = 0; i < coursesCompleted.length; i++){
			for(int j = 0; j < socialScienceCoursesInMajor.length; j++){
				if(coursesCompleted[i].getCourseNumber().equals(socialScienceCoursesInMajor[j].getCourseNumber())){
					socialScienceCoursesNeeded[j] = null;
				}
			}
		}
		for(int i = 0; i < socialScienceCoursesNeeded.length; i++){
			if(socialScienceCoursesNeeded[i] != null){
				output = output + socialScienceCoursesNeeded[i].toString();
			}
		}
		return output;
	}
	/**
	 * Find courses needed for humanities
	 * 
	 * @param s the student
	 * @return  the students courses in String form
	 */
	public String humanitiesNeeded(Student s) {
		Course[] coursesCompleted = s.getCoursesCompleted();
		Course[] humanitiesCoursesInMajor = s.getMajor().getHumCourses();
		
		Course[] humanitiesCoursesNeeded = humanitiesCoursesInMajor.clone();
		String output = "";
		
		for(int i = 0; i < coursesCompleted.length; i++){
			for(int j = 0; j < humanitiesCoursesInMajor.length; j++){
				if(coursesCompleted[i].getCourseNumber().equals(humanitiesCoursesInMajor[j].getCourseNumber())){
					humanitiesCoursesNeeded[j] = null;
				}
			}
		}
		for(int i = 0; i < humanitiesCoursesNeeded.length; i++){
			if(humanitiesCoursesNeeded[i] != null){
				output = output + humanitiesCoursesNeeded[i].toString();
			}
		}
		return output;
	}
	/**
	 * Find the total credits required for a major
	 * 
	 * @param s the student
	 * @return  the number of credits needed
	 */
	public double totalCreditsRequired(Student s) {
		double total = 0;
		
		for(int i = 0; i < s.getMajor().getMajorCourses().length; i++){
			total += s.getMajor().getMajorCourses()[i].getCredits();
		}
		for(int i = 0; i < s.getMajor().getSciCourses().length; i++){
			total += s.getMajor().getSciCourses()[i].getCredits();
		}
		for(int i = 0; i < s.getMajor().getMatCourses().length; i++){
			total += s.getMajor().getMatCourses()[i].getCredits();
		}
		for(int i = 0; i < s.getMajor().getEngCourses().length; i++){
			total += s.getMajor().getEngCourses()[i].getCredits();
		}
		for(int i = 0; i < s.getMajor().getHumCourses().length; i++){
			total += s.getMajor().getHumCourses()[i].getCredits();
		}
		for(int i = 0; i < s.getMajor().getSscCourses().length; i++){
			total += s.getMajor().getSscCourses()[i].getCredits();
		}
		
		return total;
	}
	/**
	 * Find credits earned
	 * 
	 * @param s the student
	 * @return  the amount of credits earned
	 */
	public double totalCreditsTaken(Student s) {
		double total = 0;
		
		for(int i = 0; i < s.getCoursesCompleted().length; i++){
			total += s.getCoursesCompleted()[i].getCredits();
		}
		return total;
	}
	/**
	 * Find credits needed
	 * 
	 * @param s the student
	 * @return  the amount of credits needed
	 */
	public double totalCreditsNeeded(Student s) {
		return totalCreditsRequired(s) - totalCreditsTaken(s);
	}
	
	public String[] CoursesInProgressStringArray(Student s) {
		String[] output = new String[s.getCoursesInProgress().length];
		
		for(int i = 0; i < s.getCoursesInProgress().length; i++) {
			output[i] = s.getCoursesInProgress()[i].toString();
		}
		return output;
	}
	/**
	 * Find courses a teacher teaches with a student
	 * 
	 * @param s the student
	 * @return  the students courses in String array form
	 */
	public String[] CourseTeacherHasWithStudent(Student s, Teacher t) {
		String[] output = new String[1];
		
		for(int i = 0; i < s.getCoursesInProgress().length; i++) {
			if(s.getCoursesInProgress()[i].getCourseNumber().equals(t.getCourseTaught().getCourseNumber())){
				output[0] = s.getCoursesInProgress()[i].toString();
			}
		}
		return output;
	}
	/**
	 * determine if a teacher teaches a student
	 * 
	 * @param s the student
	 * @param t the teacher
	 * @return  boolean
	 */
	public boolean teacherHasStudent(Student s, Teacher t){
		
		for(int i = 0; i < t.getStudentsTaught().length; i++){
			if(s.getID().equals(t.getStudentsTaught()[i].getID())){
				return true;
			}
		}
		return false;
		
	}

}
