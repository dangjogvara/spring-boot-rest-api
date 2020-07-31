package com.dangjogvara.demo.api;

import com.dangjogvara.demo.model.Person;
import com.dangjogvara.demo.service.PersonService;

public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	public void addPerson(Person person) {
		personService.addPerson(person);
	}

}
