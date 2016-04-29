package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Major;
import model.MajorBag;

public class WhatIfView implements View{
	HBox pane = new HBox();
	Button whatIfButton = new Button("Enter");
	IWhatIfListener listen;
	ComboBox<Major> cb;
	Label whatIf = new Label("Pick a major!");
	
	public WhatIfView(IWhatIfListener listener) {
		listen = listener;
		cb = new ComboBox<Major>(FXCollections.observableArrayList(MajorBag.bag.values()));
		
		whatIfButton.setOnAction(e->{
			if(cb.getValue() != null){
				WhatIfEvent wie = new WhatIfEvent(this, cb.getValue().getMajorID());
				listen.getMajorID(wie);
			}
			
		});
		
		pane.getChildren().addAll(whatIf, cb, whatIfButton);
	}

	@Override
	public Pane getPane() {
		return pane;
	}
}
