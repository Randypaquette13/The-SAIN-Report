package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Admin;

public class AdminTest {
	Admin a1 = new Admin("name", "username", "ID");
	@Test
	public void testGetName() {
		assertTrue(a1.getName() == "name");
	}
	
	@Test
	public void testGetUsername() {
		assertTrue(a1.getUsername() == "username");
	}
	
	@Test
	public void testGetID() {
		assertTrue(a1.getID() == "ID");
	}

}
