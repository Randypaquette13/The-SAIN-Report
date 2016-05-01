package view;

import java.util.EventObject;

public class UpdateGradesEvent extends EventObject{
	double[] grades;
	
	public UpdateGradesEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public UpdateGradesEvent(Object source, double[] grades) {
		super(source);
		this.grades = grades;
	}

	public double[] getGrades() {
		return grades;
	}

}
