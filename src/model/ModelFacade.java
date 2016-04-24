package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ModelFacade {
	AccountBag studentBag;
	AccountBag TeacherBag;
	AccountBag AdminBag;
	
	public ModelFacade() {
		Course c1  = new Course("c00001", "Intro to Computing", 3);//course# starts with a c and has 5 digits
		Course c2  = new Course("c00002", "Intro to Networking", 3);
		Course c3  = new Course("c00003", "World Literature", 1);
		Course c4  = new Course("c00004", "Biology Lab", 1.5);
		Course c5  = new Course("c00005", "Calculus I", 3);
		Course c6  = new Course("c00006", "Intro to Philosophy", 2);
		Course c7  = new Course("c00007", "Spanish I", 1.5);
		Course c8  = new Course("c00008", "Principles of Computing Using Java", 4);
		Course c9  = new Course("c00009", "Network Topologies", 3);
		Course c10 = new Course("c00010", "Play Writing", 3);
		Course c11 = new Course("c00011", "Chemistry Lab", 1.5);
		Course c12 = new Course("c00012", "Calculus II", 3);
		Course c13 = new Course("c00013", "Intro to Psychology", 2);
		Course c14 = new Course("c00014", "Spanish II", 3);
		
		Major m1 = new Major("Computer Science", "m00001", new Course[]{c1, c8}, new Course[]{c3}, new Course[]{c11}, new Course[]{c5, c12}, new Course[]{c6}, new Course[]{c7});
		Major m2 = new Major("Information Technology", "m00002", new Course[]{c2, c9}, new Course[]{c10}, new Course[]{c4}, new Course[]{c5, c12}, new Course[]{c13}, new Course[]{c7, c14});
		
		//username is first initial + lasname + 1
		Student s1  = new Student("Jools Thompson", "jThompson1", "s00001", "m00001",     new Course[]{c1.copy(3.6), c3.copy(3.2)},  new Course[]{c8.copy(.2)},  new Course[]{c8});
		Student s2  = new Student("Stevie Brant", "sBrant1", "s00002", "m00001",          new Course[]{c1.copy(3.4), c3.copy(2.0)},  new Course[]{c12.copy(.3)}, new Course[]{c4});
		Student s3  = new Student("Léonide Foster", "lFoster1", "s00003", "m00001",       new Course[]{c2.copy(2.0), c9.copy(3.0)},  new Course[]{},             new Course[]{c11, c12, c1});
		Student s4  = new Student("Hilary Sams", "hSams1", "s00004", "m00001",            new Course[]{c7.copy(4.0), c14.copy(3.4)}, new Course[]{},             new Course[]{c3, c12, c1});
		Student s5  = new Student("Dee Shakesheave", "dShakesheave1", "s00005", "m00001", new Course[]{c6.copy(4.0)},                new Course[]{c10.copy(.3)}, new Course[]{c13});
		Student s6  = new Student("Ashton Vincent", "aVincent1", "s00006", "m00001",      new Course[]{c1.copy(3.3)},                new Course[]{c11.copy(.3)}, new Course[]{c7, c10});
		Student s7  = new Student("Ash Blackburn", "aBlackburn1", "s00007", "m00002",     new Course[]{c5.copy(3.5), c7.copy(3.2)},  new Course[]{c3.copy(.3)},  new Course[]{c2});
		Student s8  = new Student("Maria Lennon", "mLennon1", "s00008", "m00002",         new Course[]{c2.copy(3.0), c4.copy(3.6)},  new Course[]{c1.copy(.3)},  new Course[]{c6, c13});
		Student s9  = new Student("Dale Ferrero", "dFerrero1", "s00009", "m00002",        new Course[]{c2.copy(2.0), c3.copy(3.7)},  new Course[]{c5.copy(.3)},  new Course[]{c8});
		Student s10 = new Student("Celeste O'Shea", "cO'Shea1", "s00010", "m00002",       new Course[]{c2.copy(3.0), c6.copy(3.9)},  new Course[]{},             new Course[]{c14, c11});
		Student s11 = new Student("Esme Caiazzo", "eCaiazzo1", "s00011", "m00002",        new Course[]{c2.copy(3.0), c7.copy(4.0)},  new Course[]{},             new Course[]{c9, c1});
		Student s12 = new Student("Tracey Baldinotti", "tBaldinotti", "s00012", "m00002", new Course[]{},                            new Course[]{},             new Course[]{c1, c2, c5});
		
		Teacher t1  = new Teacher("Donna Nelson", "dNelson2", "t00001", c1, new Student[]{s3, s4, s11, s12});
		Teacher t2  = new Teacher("Dennis Lewis", "dLewis2", "t00002", c2, new Student[]{s7, s12});
		Teacher t3  = new Teacher("Brenda Bell", "bBell2", "t00003", c3, new Student[]{s4});
		Teacher t4  = new Teacher("Denise Martin", "dMartin2", "t00004", c4, new Student[]{s2});
		Teacher t5  = new Teacher("Albert Allen", "aAllen2", "t00005", c5, new Student[]{s12});
		Teacher t6  = new Teacher("Sandra Coleman", "sColeman2", "t00006", c6, new Student[]{s8});
		Teacher t7  = new Teacher("Shirley Miller", "sMiller2", "t00007", c7, new Student[]{s6});
		Teacher t8  = new Teacher("Alice Turner", "aTurner2", "t00008", c8, new Student[]{s1, s9});
		Teacher t9  = new Teacher("Joshua Brown", "jBrown2", "t00009", c9, new Student[]{s11});
		Teacher t10 = new Teacher("Louis Watson", "lWatson2", "t00010", c10, new Student[]{s6});
		Teacher t11 = new Teacher("Emily Butler", "eButler2", "t00011", c11, new Student[]{s3, s10});
		Teacher t12 = new Teacher("Victor Washington", "vWashington2", "t00012", c12, new Student[]{s3, s4});
		Teacher t13 = new Teacher("Adam	Flores", "aFlores2", "t00013", c13, new Student[]{s8});
		Teacher t14 = new Teacher("Kelly Thomas", "kThomas2", "t00014", c14, new Student[]{s10});
		
		Admin a1 = new Admin("Earl Alexander", "eAlexander3", "a00001");
		
		MajorBag.bag.put(m1.getMajorID(), m1);
		MajorBag.bag.put(m2.getMajorID(), m2);
		
		studentBag.bag.put(s1.getID(),  s1);
		studentBag.bag.put(s2.getID(),  s2);
		studentBag.bag.put(s3.getID(),  s3);
		studentBag.bag.put(s4.getID(),  s4);
		studentBag.bag.put(s5.getID(),  s5);
		studentBag.bag.put(s6.getID(),  s6);
		studentBag.bag.put(s7.getID(),  s7);
		studentBag.bag.put(s8.getID(),  s8);
		studentBag.bag.put(s9.getID(),  s9);
		studentBag.bag.put(s10.getID(), s10);
		studentBag.bag.put(s11.getID(), s11);
		studentBag.bag.put(s12.getID(), s12);
		
		TeacherBag.bag.put(t1.getID(),  t1);
		TeacherBag.bag.put(t2.getID(),  t2);
		TeacherBag.bag.put(t3.getID(),  t3);
		TeacherBag.bag.put(t4.getID(),  t4);
		TeacherBag.bag.put(t5.getID(),  t5);
		TeacherBag.bag.put(t6.getID(),  t6);
		TeacherBag.bag.put(t7.getID(),  t7);
		TeacherBag.bag.put(t8.getID(),  t8);
		TeacherBag.bag.put(t1.getID(),  t9);
		TeacherBag.bag.put(t10.getID(), t10);
		TeacherBag.bag.put(t11.getID(), t11);
		TeacherBag.bag.put(t12.getID(), t12);
		TeacherBag.bag.put(t13.getID(), t13);
		TeacherBag.bag.put(t14.getID(), t14);
		
		AdminBag.bag.put(a1.getID(), a1);
		
	}

	public AccountBag getStudentBag() {
		return studentBag;
	}
	
	public AccountBag getTeacherBag() {
		return TeacherBag;
	}

	public AccountBag getAdminBag() {
		return AdminBag;
	}
	

}
