package jUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import model.Course;
import model.Student;

public class StudentTest {

	Course c1 = new Course("c00001", "Intro to Psychology", 2);
	Student s1 = new Student("name", "username", "ID", "majorID",new Course[]{}, new Course[]{c1.copy(0)}, new Course[]{});
	
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
