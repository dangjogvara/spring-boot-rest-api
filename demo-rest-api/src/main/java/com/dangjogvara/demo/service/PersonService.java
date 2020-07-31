package com.dangjogvara.demo.service;

import com.dangjogvara.demo.dao.PersonDao;
import com.dangjogvara.demo.model.Person;

public class PersonService {

	public PersonDao personDao;

	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
}
