package jUnit;

import static org.junit.Assert.*;

import org.junit.Test;

import controller.SortStudentsCourses;
import model.Course;
import model.ModelFacade;
import model.Student;

public class SortCoursesTakenTest {

	SortStudentsCourses sct = new SortStudentsCourses();
	
	ModelFacade mf = new ModelFacade();
	
	@Test
	public void testCoursesTakenInMajor() {
		assertTrue(sct.coursesTakenInMajor((Student) mf.getStudentBag().bag.get("s00001")).equals("\nIntro to Computing Credits: 3.0 Grade: 3.6"));
	}
	
	@Test
	public void testCoursesTakenNotInMajor() {
		assertTrue(sct.coursesTakenNotInMajor((Student) mf.getStudentBag().bag.get("s00001")).equals("\nWorld Literature Credits: 1.0 Grade: 3.2"));
	}
	
	@Test
	public void testCoursesFailed() {		
		assertTrue(sct.coursesFailed((Student) mf.getStudentBag().bag.get("s00001")).equals("\nPoC Using Java Credits: 4.0 Grade: 0.2"));
	}
	
	@Test
	public void testCoursesInProgress() {		
		assertTrue(sct.majorCoursesNeeded((Student) mf.getStudentBag().bag.get("s00001")).equals("\nPoC Using Java Credits: 4.0"));
	}
	
	@Test
	public void testMajorCoursesNeeded() {		
		assertTrue(sct.majorCoursesNeeded((Student) mf.getStudentBag().bag.get("s00001")).equals("\nPoC Using Java Credits: 4.0"));
	}
	
	@Test
	public void testEnglishCoursesNeeded() {
		assertTrue(sct.englishCoursesNeeded((Student) mf.getStudentBag().bag.get("s00003")).equals("\nWorld Literature Credits: 1.0"));
	}
	
	@Test
	public void testScienceCoursesNeeded() {
		assertTrue(sct.scienceCoursesNeeded((Student) mf.getStudentBag().bag.get("s00001")).equals("\nChemistry Lab Credits: 1.5"));
	}
	
	@Test
	public void testMathCoursesNeeded() {
		assertTrue(sct.mathCoursesNeeded((Student) mf.getStudentBag().bag.get("s00001")).equals(((Student) mf.getStudentBag().bag.get("s00001")).getMajor().getMatCourses()[0].toString() + ((Student) mf.getStudentBag().bag.get("s00001")).getMajor().getMatCourses()[1].toString()));
	}
	
	@Test
	public void testSocialScenceCoursesNeeded() {
		assertTrue(sct.socialScienceCoursesNeeded((Student) mf.getStudentBag().bag.get("s00001")).equals("\nIntro to Philosophy Credits: 2.0"));
	}
	
	@Test
	public void testHumanitiesCoursesNeeded() {
		assertTrue(sct.humanitiesNeeded((Student) mf.getStudentBag().bag.get("s00001")).equals("\nSpanish I Credits: 1.5"));
	}
	
	@Test
	public void testTotalCreditsRequired() {
		assertTrue(sct.totalCreditsRequired((Student) mf.getStudentBag().bag.get("s00001")) == 19.0);
	}
	
	@Test
	public void testTotalCreditsTaken() {
		assertTrue(sct.totalCreditsTaken((Student) mf.getStudentBag().bag.get("s00001")) == 4.0);
	}

}
