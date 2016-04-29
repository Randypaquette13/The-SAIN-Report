package view;

import java.util.EventObject;

public class LoginEvent extends EventObject{

	String username;
	String ID;
	
	public LoginEvent(Object source, String username, String iD) {
		super(source);
		this.username = username;
		ID = iD;
	}

	public LoginEvent(Object source) {
		super(source);
	}

	public String getUsername() {
		return username;
	}

	public String getID() {
		return ID;
	}

}
