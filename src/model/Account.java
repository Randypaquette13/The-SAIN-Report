package model;

import java.io.Serializable;
/**
 * interface for Student, Teacher, and Admin to implement
 * @author Randy
 *
 */
public interface Account extends Serializable{
	String getName();
	String getUsername();
	String getID();
	int getPermissionLevel();
}
