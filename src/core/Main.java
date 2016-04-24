package core;

import java.util.HashMap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.ModelFacade;
import model.Student;
import view.LoginView;

public class Main extends javafx.application.Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		ModelFacade mf = new ModelFacade();
		
		LoginView lv = new LoginView();
		primaryStage.setScene(new Scene(lv.getPane()));//to be handled by the controller
		primaryStage.setHeight(340);
		primaryStage.setWidth(654);
		
		primaryStage.setTitle("The SAIN Report");
		primaryStage.show();
		
	}

}
