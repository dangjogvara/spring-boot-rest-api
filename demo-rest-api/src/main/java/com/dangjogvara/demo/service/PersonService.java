package com.dangjogvara.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.dangjogvara.demo.dao.PersonDao;
import com.dangjogvara.demo.model.Person;

@Service
public class PersonService {

	public PersonDao personDao;

	@Autowired
	public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
		this.personDao = personDao;
	}

	public int addPerson(Person person) {
		return personDao.insertPerson(person);
	}
}
