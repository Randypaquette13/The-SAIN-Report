package core;

import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
		
//		LoginView lv = new LoginView();
		
		Course c1 = new Course("c00001", "Intro to Psychology", 2);
		Student s1 = new Student("name", "username", "ID", "m00001",new Course[]{}, new Course[]{c1.copy(0)}, new Course[]{});
		StudentView sv = new StudentView(s1.getName(), s1.getID(), s1.getMajor().getTitle(), String.valueOf(s1.getGpa()));
				
				
		primaryStage.setScene(new Scene(sv.getPane()));//to be handled by the controller
		primaryStage.setHeight(1000);
		primaryStage.setWidth(1000);
		
		primaryStage.setTitle("The SAIN Report");
		primaryStage.show();
		
	}

}
