package br.com.cadamuro.service;

import java.util.concurrent.atomic.AtomicLong;

import br.com.cadamuro.model.Person;

public class PersonService implements IPersonService {

	@Override
	public Person createPerson(Person person) {
		
		if (person.getEmail() == null || person.getEmail().equals(""))
			throw new IllegalArgumentException("The Person Email is Null or Empty.");
		
		var id = new AtomicLong().incrementAndGet();
		person.setId(id);
		return person;		
	}

}
