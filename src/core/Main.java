package core;

import java.util.HashMap;

import controller.ControllerFacade;
import controller.SortCoursesTaken;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Account;
import model.Course;
import model.ModelFacade;
import model.Student;
import view.LoginView;
import view.StudentView;

public class Main extends javafx.application.Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ModelFacade mf = new ModelFacade();
		
		ControllerFacade cf = new ControllerFacade(primaryStage, mf);
		
		
	}

}
