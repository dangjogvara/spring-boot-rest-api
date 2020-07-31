package com.dangjogvara.demo.dao;

import java.util.UUID;

import com.dangjogvara.demo.model.Person;

public interface PersonDao {

	// Insert person object
	int insertPerson(UUID id, Person person);

	default int addPerson(Person person) {
		UUID id = UUID.randomUUID();
		return insertPerson(id, person);
	}

}
