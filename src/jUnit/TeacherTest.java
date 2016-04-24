package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Teacher;

public class TeacherTest {
	Teacher t1 = new Teacher("name", "username", "ID", null, null);
	
	@Test
	public void testGetName() {
		assertTrue(t1.getName() == "name");
	}
	
	@Test
	public void testGetUsername() {
		assertTrue(t1.getUsername() == "username");
	}
	
	@Test
	public void testGetID() {
		assertTrue(t1.getID() == "ID");
	}

}
