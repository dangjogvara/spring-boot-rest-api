package com.dangjogvara.demo.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dangjogvara.demo.model.Person;
import com.dangjogvara.demo.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

	private final PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@PostMapping
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}

	@GetMapping
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}

	@GetMapping(path = "/{id}")
	public Person getPersonByid(@PathVariable("id") UUID id) {
		return personService.getPersonById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
	}

}
