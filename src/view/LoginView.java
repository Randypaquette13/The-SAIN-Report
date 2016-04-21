package view;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import jdk.nashorn.internal.runtime.regexp.joni.Config;

public class LoginView {
	
	Scene scene;
	
	Image image = new Image("resources/images/SuffolkLogo.png");
	ImageView iv = new ImageView(image);
	Label title = new Label("The SAIN Report Login");
	
	TextField usernameF = new TextField();
	TextField idF = new TextField();
	Label usernameL = new Label("Username: ");
	Label idL = new Label("ID Number: ");
	Button loginB = new Button("Login");
	
	FlowPane flow;//added to scene, contains gridpane
	GridPane gp;
	
	public LoginView(){
		flow = new FlowPane(Orientation.VERTICAL);

		title.setAlignment(Pos.CENTER);
		title.setGraphic(iv);
		title.setGraphicTextGap(5);
		title.setContentDisplay(ContentDisplay.TOP);
		title.setTextFill(Color.BLUE);
		title.setFont(new Font("Arial", 56));//TODO: change to Arial you idiot
		
		gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
		gp.setHgap(10);
		gp.setVgap(5);
		
		gp.add(usernameL, 0, 0);
		gp.add(idL, 1, 0);
		gp.add(usernameF, 0, 1);
		gp.add(idF, 1, 1);
		gp.add(loginB, 1, 2);
		
		flow.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
		flow.setAlignment(Pos.TOP_CENTER);
		flow.setPrefSize(700, 700);
		flow.setVgap(8);
		
		flow.getChildren().addAll(title, gp);
		
		scene = new Scene(flow);
	}

	public Scene getScene() {
		return scene;
	}
}
