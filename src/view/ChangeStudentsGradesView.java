package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ChangeStudentsGradesView implements View {
	GridPane gp = new GridPane();
	Button updateButton = new Button("Update");
	Label changeGrades = new Label("Change grades");
	Label errormsg = new Label();
	
	IUpdateGradesListener listen;
	
	public ChangeStudentsGradesView(String[] classes, IUpdateGradesListener listener){
		listen = listener;
		TextField[] tf = new TextField[classes.length];
		
		for(int i = 0; i < classes.length; i++){
			Label l = new Label(classes[i]);
			tf[i] = new TextField();
			
			gp.add(l, 0, (i + 1));
			gp.add(tf[i], 1, (i + 1));
		}
		
		updateButton.setOnAction(e-> {
			double[] grades = new double[classes.length];
			for(int i = 0; i < classes.length; i++){
				try {
					grades[i] = Double.parseDouble(tf[i].getText());
					if(grades[i] > 4.0 || grades[i] < 0){
						grades[i] = -50;
					}
				} catch (Exception e1) {
					grades[i] = -50;
					System.out.println("lmao");
				}
			}
			UpdateGradesEvent uge = new UpdateGradesEvent(this, grades);
			errormsg.setText(listen.getGrades(uge));
		});
		
		gp.add(changeGrades, 0, 0);
		gp.add(updateButton, 1, 0);
		gp.add(errormsg, 2, 0);
		gp.setVgap(4);
	}

	@Override
	public Pane getPane() {
		return gp;
	}

}
