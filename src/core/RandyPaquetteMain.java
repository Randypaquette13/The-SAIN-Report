package core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import controller.LoginButtonHandling;
import controller.SortStudentsCourses;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import model.Account;
import model.AccountBag;
import model.Course;
import model.ModelFacade;
import model.Student;
import view.LoginView;
import view.StudentView;

public class RandyPaquetteMain extends javafx.application.Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ModelFacade mf = new ModelFacade();
		LoginButtonHandling cf = new LoginButtonHandling(primaryStage, mf);
			
	}
}
