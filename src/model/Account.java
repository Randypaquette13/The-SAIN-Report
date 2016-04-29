package model;

import java.io.Serializable;

public interface Account extends Serializable{
	String getName();
	String getUsername();
	String getID();
	int getPermissionLevel();
}
