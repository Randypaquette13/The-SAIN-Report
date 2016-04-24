package jUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Student;

public class StudentTest {

	Student s1 = new Student("name", "username", "ID", "majorID", 0, null, null, null);
	
	@Test
	public void testGetName() {
		assertTrue(s1.getName() == "name");
	}
	@Test
	public void testGetUserName() {
		assertTrue(s1.getUsername() == "username");
	}
	@Test
	public void testGetID() {
		assertTrue(s1.getID() == "ID");
	}
	@Test
	public void testGetMajorID() {
		assertTrue(s1.getMajorID() == "majorID");
	}
	@Test
	public void testGetGPA() {
		assertTrue(s1.getGpa() == 0);
	}

}
