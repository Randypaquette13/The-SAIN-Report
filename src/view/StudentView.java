package view;



import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class StudentView implements View{
	VBox masterPane = new VBox();
	GridPane studentInfoPane = new GridPane();
	HBox courseInfoPane = new HBox();
	
	Label name;
	Label ID;
	Label major;
	Label GPA;
	
	public StudentView(String name, String ID, String major, String gpa, ){
		this.name  = new Label(name);
		this.ID    = new Label(ID);
		this.major = new Label(major);
		this.GPA   = new Label(gpa);
		
		
		studentInfoPane.setHgap(10);
		studentInfoPane.setVgap(4);
		studentInfoPane.setPrefSize(100, 100);
		studentInfoPane.add(this.name, 0, 0);
		studentInfoPane.add(this.ID, 0, 1);
		studentInfoPane.add(this.major, 1, 0);
		studentInfoPane.add(this.GPA, 1, 1);
		
		courseInfoPane.setPrefSize(900, 400);
		
		masterPane.getChildren().addAll(studentInfoPane, courseInfoPane);
	}

	@Override
	public Pane getPane() {
		return masterPane;
	}
	
	

}
