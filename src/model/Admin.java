package model;

public class Admin implements Account{
	String name;
	String username;
	String ID;
	static final int permissionLevel = Vars.ADMIN_PERMISSION_LEVEL;
	
	public Admin(String name, String username, String ID) {
		this.name = name;
		this.username = username;
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public String getUsername() {
		return username;
	}
	
	public String getID() {
		return ID;
	}

	public int getPermissionLevel() {
		return permissionLevel;
	}
	
	

}
