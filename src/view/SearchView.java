package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class SearchView implements View{
	VBox mPane = new VBox();
	HBox sPane = new HBox();
	
	ISearchListener listen;
	
	Button searchB = new Button("Search");
	Label searchL = new Label("Student's ID: ");
	TextField searchF = new TextField();
	Label errorMsg = new Label();
	
	public SearchView(ISearchListener listener){
		listen = listener;
		
		searchB.setOnAction(e-> {
			SearchEvent se = new SearchEvent(this, searchF.getText());
			errorMsg.setText(listen.search(se));//search() outputs an error message
		});
		
		sPane.setSpacing(5);
		sPane.setAlignment(Pos.CENTER);
		sPane.getChildren().addAll(searchF, searchB);
		
		mPane.setAlignment(Pos.CENTER);
		mPane.getChildren().addAll(searchL, sPane, errorMsg);
	}

	@Override
	public Pane getPane() {
		return mPane;
	}
}
