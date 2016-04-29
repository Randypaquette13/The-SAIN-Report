package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.AccountBag;
import model.ModelFacade;
import model.Student;
import view.ILoginListener;
import view.IWhatIfListener;
import view.LoginEvent;
import view.LoginView;
import view.StudentView;
import view.WhatIfEvent;
import view.WhatIfView;

public class LoginButtonHandling {
	
	public LoginButtonHandling(Stage stage, ModelFacade mf){
		AuthenticateLogin auth = new AuthenticateLogin(stage);
		
		LoginView lv = new LoginView(new ILoginListener() {
			
			@Override
			public void getLoginDetails(LoginEvent e) {
				auth.tryLogin(e.getUsername(), e.getID());
			}
		});
		
		stage.setScene(new Scene(lv.getPane()));//to be handled by the controller
		stage.setHeight(340);
		stage.setWidth(654);
		
		stage.setTitle("The SAIN Report");
		stage.show();
	}

}
