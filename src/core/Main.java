package core;

import java.awt.GraphicsEnvironment;
import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import view.LoginView;

public class Main extends javafx.application.Application {

	public static void main(String[] args) {
		Application.launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		LoginView lv = new LoginView();
		
		primaryStage.setScene(lv.getScene());//to be handled by the controller
		primaryStage.setHeight(340);
		primaryStage.setWidth(654);
		
		primaryStage.setTitle("The SAIN Report");
		primaryStage.show();
		
	}

}
