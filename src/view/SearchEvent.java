package view;

import java.util.EventObject;

public class SearchEvent extends EventObject {
	String studentID;
	
	public SearchEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public SearchEvent(Object source, String studentID) {
		super(source);
		this.studentID = studentID;
	}

	public String getStudentID() {
		return studentID;
	}

}
