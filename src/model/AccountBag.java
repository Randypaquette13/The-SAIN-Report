package model;

import java.io.Serializable;
import java.util.HashMap;

public class AccountBag implements Serializable{
	//string represents the account ID
	public HashMap<String, Account> bag = new HashMap<>();
	
	public AccountBag() {
		
	}
	
	
}
