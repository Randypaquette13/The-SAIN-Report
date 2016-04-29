package view;



import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
	//recommended size
//	stage.setHeight(1000);
//	stage.setWidth(1000);
	VBox masterPane = new VBox();
	GridPane studentInfoPane = new GridPane();
	HBox courseInfoPane = new HBox();
	VBox currentStatus = new VBox();
	
	Label name;
	Label ID;
	Label major;
	Label GPA;
	Label totalCreditsTaken = new Label("Total Credits Taken:    ");
	Label totalCreditsRequired = new Label("Credits Required For Major:    ");
	Label totalCreditsNeeded = new Label("Total Credits Needed:    ");
	
	TextArea ctimArea = new TextArea("Courses Taken In Major:\n");
	TextArea ctnimArea = new TextArea("Courses Taken Not In Major:\n");
	TextArea cfArea = new TextArea("Courses Failed:\n");
	TextArea cipArea = new TextArea("Courses In Progress:\n");
	
	TextArea requiredCourses = new TextArea();
	
	Button logoutB = new Button("Logout");
	Button whatIfB = new Button("What If?");
	
	ILogoutListener logoutListen;
	IGoToWhatIfListener whatIfListen;
	
	public StudentView(String nameS, String IDS, String majorS, String gpaS, String coursesTakenInMajor, String coursesTakenNotInMajor, String coursesFailed, String coursesInProgress, 
						String rcMajor, String rcEnglish, String rcScience, String rcMath, String rcSocialSciences, String rcHumanities, String totalCreditsTakenS, String totalCreditsRequiredS, String totalCreditsNeededS){
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
		studentInfoPane.setPrefSize(200, 100);
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
		courseInfoPane.setPadding(new Insets(0, 0, 10, 0));
		courseInfoPane.getChildren().addAll(ctimArea, ctnimArea, cfArea, cipArea);
		courseInfoPane.setPrefSize(900, 400);
		
		Label coursesNeededL = new Label("Courses Needed");
		
		requiredCourses.appendText(majorS + " courses:" + rcMajor + "\n\nEnglish courses:" + rcEnglish + "\n\nScience courses:" + rcScience + "\n\nMath courses:" + rcMath + "\n\nSocialSciences courses:" + rcSocialSciences + "\n\nHumanities courses:" + rcHumanities);
		
		totalCreditsTaken.setText(totalCreditsTaken.getText() + totalCreditsTakenS);
		totalCreditsRequired.setText(totalCreditsRequired.getText() + totalCreditsRequiredS);
		totalCreditsNeeded.setText(totalCreditsNeeded.getText() + totalCreditsNeededS);
		
		whatIfB.setOnAction(e->{
			if(whatIfListen != null){
				whatIfListen.goToWhatIf();
			}
		});
		
		logoutB.setOnAction(e->{
			if(logoutListen != null){
				logoutListen.logout();
			}
		});
		
		currentStatus.getChildren().addAll(totalCreditsRequired, totalCreditsTaken, totalCreditsNeeded, whatIfB, logoutB);
		
		masterPane.setPadding(new Insets(5));
		masterPane.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), new Insets(0))));
		masterPane.getChildren().addAll(studentInfoPane, courseInfoPane, coursesNeededL, requiredCourses, currentStatus);
	}

	@Override
	public Pane getPane() {
		return masterPane;
	}
	
	public void setLogoutListener(ILogoutListener listener){
		logoutListen = listener;
	}
	
	public void setGoToWhatIfListener(IGoToWhatIfListener listener){
		whatIfListen = listener;
	}
	
	

}
