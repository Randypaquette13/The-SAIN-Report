package model;

import java.util.ArrayList;
/**
 * Stores information on the student
 * @author Randy
 *
 */
public class Teacher implements Account{
	String name;
	String username;
	String ID;
	static final int permissionLevel = Vars.TEACHER_PERMISSION_LEVEL;
	
	Course courseTaught;
	Student[] studentsTaught;
	
	public Teacher(String name, String username, String ID, Course courseTaught, Student[] studentsTaught) {
		this.name = name;
		this.username = username;
		this.ID = ID;
		this.courseTaught = courseTaught;
		this.studentsTaught = studentsTaught;
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

	public int getPermissionLevel() {
		return permissionLevel;
	}

	public Course getCourseTaught() {
		return courseTaught;
	}

	public Student[] getStudentsTaught() {
		return studentsTaught;
	}
	

}
