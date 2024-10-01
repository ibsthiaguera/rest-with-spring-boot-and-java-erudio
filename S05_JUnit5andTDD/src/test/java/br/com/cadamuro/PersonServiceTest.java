package br.com.cadamuro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.com.cadamuro.model.Person;
import br.com.cadamuro.service.IPersonService;
import br.com.cadamuro.service.PersonService;

public class PersonServiceTest {

	Person person;
	IPersonService service;

	@BeforeEach
	void setup() {
		person = new Person("Keith", "Moon", "keith.moon@gmail.com", "Wembley - UK", "Male");
		service = new PersonService();
	}

	@Test
	@DisplayName("When Create a Person with Success Should Return a Person Object")
	void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

		// Given / Arrange

		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		assertNotNull(actual, () -> "The createPerson() should not have returned null!");
	}

	@Test
	@DisplayName("When Create a Person with Success Should Contains Valid Fields In Returned Person Object")
	void testCreatePerson_WhenSuccess_ShouldContainsValidFieldsInReturnedPersonObject() {

		// Given / Arrange

		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		assertNotNull(person.getId(), () -> "Person ID is missing!");
		assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The Person FirstName is incorrect!");
		assertEquals(person.getLastName(), actual.getLastName(), () -> "The Person LastName is incorrect!");
		assertEquals(person.getAddress(), actual.getAddress(), () -> "The Person Address is incorrect!");
		assertEquals(person.getGender(), actual.getGender(), () -> "The Person Gender is incorrect!");
		assertEquals(person.getEmail(), actual.getEmail(), () -> "The Person Email is incorrect!");
	}

	@Test
	@DisplayName("When Create a Person with Null Email Should throw Exception")
	void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {

		// Given / Arrange
		person.setEmail(null);
		
		var expectedMessage = "The Person Email is Null or Empty.";
		
		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> service.createPerson(person), () -> "Empty Email should have caused an IllegalArgumentException!");
		assertEquals(expectedMessage, exception.getMessage(), () -> "Exception error message is incorrect.");
		
	}
}
