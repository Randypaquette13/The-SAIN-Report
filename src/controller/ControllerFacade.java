package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ModelFacade;
import model.Student;
import view.StudentView;

public class ControllerFacade {
	
	public ControllerFacade(Stage stage, ModelFacade mf){
		
		SortCoursesTaken cs = new SortCoursesTaken();
		Student s = (Student) mf.getStudentBag().bag.get("s00001");
		StudentView sv = new StudentView(s.getName(), s.getID(), s.getMajor(), s.getGpa(), cs.coursesTakenInMajor(s), cs.coursesTakenNotInMajor(s), s.getCoursesFailed(), s.getCoursesInProgress(), cs.majorCoursesNeeded(s), cs.englishCoursesNeeded(s), cs.scienceCoursesNeeded(s), cs.mathCoursesNeeded(s), cs.socialScienceCoursesNeeded(s), cs.humanitiesNeeded(s));
				
		stage.setScene(new Scene(sv.getPane()));//to be handled by the controller
		stage.setHeight(1000);
		stage.setWidth(1000);
		
		stage.setTitle("The SAIN Report");
		stage.show();
	}

}
