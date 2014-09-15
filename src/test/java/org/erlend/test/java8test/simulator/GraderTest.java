package org.erlend.test.java8test.simulator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.erlend.test.java8test.model.Gender;
import org.junit.Test;

public class GraderTest {

	@Test
	public void testGetAverageGrade() throws Exception {
		Grader g = new Grader();
		assertTrue(g.getAverageGrade().isPresent());
		assertEquals(3.35d, g.getAverageGrade().getAsDouble(), 0.0d);
	}
	
	@Test
	public void testGetMaleWithLaudGrade() throws Exception {
		Grader g = new Grader();
		assertEquals(2, g.getMaleWithLaudGrade().size());
		
	}
	
	@Test
	public void testGetFailingStudentsByGender() {
		Grader g = new Grader();
		assertEquals(2, g.getFailingStudentsByGender().get(Gender.MALE).size());
		assertEquals(1, g.getFailingStudentsByGender().get(Gender.FEMALE).size());
	}
}
