package br.com.cadamuro.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import br.com.cadamuro.service.CourseService;
import br.com.cadamuro.service.stubs.CourseServiceStub;

class CourseBusinessStubTest {

	@Test
	void testCoursesRelatedToSpring_When_UsingAStub() {

		// Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);

		// When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

		// Then / Assert
		assertEquals(4, filteredCourses.size());
	}

	@Test
	void testCoursesRelatedToSpring_When_UsingAFooBarStudent() {

		// Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);

		// When / Act
		var filteredCourses = business.retrieveCoursesRelatedToSpring("Foo Bar");

		// Then / Assert
		assertEquals(0, filteredCourses.size());
	}

}
