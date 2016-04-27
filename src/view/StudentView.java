package view;



import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StudentView implements View{
	VBox masterPane = new VBox();
	GridPane studentInfoPane = new GridPane();
	HBox courseInfoPane = new HBox();
	
	Label name;
	Label ID;
	Label major;
	Label GPA;
	
	TextArea ctimArea = new TextArea("Courses Taken In Major:\n");
	TextArea ctnimArea = new TextArea("Courses Taken Not In Major:\n");
	TextArea cfArea = new TextArea("Courses Failed:\n");
	TextArea cipArea = new TextArea("Courses In Progress:\n");
	
//	String coursesTakenInMajor;
//	String coursesTakenNotInMajor;
//	String coursesFailed;
//	String coursesInProgress;
	
	public StudentView(String nameS, String IDS, String majorS, String gpaS, String coursesTakenInMajor, String coursesTakenNotInMajor, String coursesFailed, String coursesInProgress, 
						String rcMajor, String rcEnglish, String rcScience, String rcMath, String rcSocialSciences, String rcHumanities){
		name  = new Label(nameS);
		ID    = new Label(IDS);
		major = new Label(majorS);
		GPA   = new Label(gpaS);
		name.setFont(new Font("Arial", 38));
		ID.setFont(new Font("Arial", 38));
		major.setFont(new Font("Arial", 38));
		GPA.setFont(new Font("Arial", 38));
		
		studentInfoPane.setHgap(15);
		studentInfoPane.setVgap(4);
		studentInfoPane.setPrefSize(200, 300);
		studentInfoPane.setPadding(new Insets(30));
		studentInfoPane.add(this.name, 0, 0);
		studentInfoPane.add(this.ID, 0, 1);
		studentInfoPane.add(this.major, 1, 0);
		studentInfoPane.add(this.GPA, 1, 1);
		
		ctimArea.appendText(coursesTakenInMajor);
		ctnimArea.appendText(coursesTakenNotInMajor);
		cfArea.appendText(coursesFailed);
		cipArea.appendText(coursesInProgress);
		ctimArea.setEditable(false);
		ctnimArea.setEditable(false);
		cfArea.setEditable(false);
		cipArea.setEditable(false);
		
		courseInfoPane.setSpacing(2);
		courseInfoPane.setPadding(new Insets(10));
		courseInfoPane.getChildren().addAll(ctimArea, ctnimArea, cfArea, cipArea);
		courseInfoPane.setPrefSize(900, 400);
		
		masterPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), new Insets(5))));
		masterPane.getChildren().addAll(studentInfoPane, courseInfoPane);
	}

	@Override
	public Pane getPane() {
		return masterPane;
	}
	
	

}
