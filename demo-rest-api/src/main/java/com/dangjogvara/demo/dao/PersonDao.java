package com.dangjogvara.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dangjogvara.demo.model.Person;

@Repository("postgres")
public class PersonDao implements IPersonDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public int insertPerson(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Person> selectAllPeople() {
		final String sql = "SELECT id, name FROM person";
		return jdbcTemplate.query(sql, (rs, i) -> {
			UUID id = UUID.fromString(rs.getString("id"));
			String name = rs.getString("name");
			return new Person(id, name);
		});
	}

	@Override
	public Optional<Person> selectPersonById(UUID id) {
		final String sql = "SELECT id, name FROM person WHERE id = ?";
		Person newPerson = jdbcTemplate.queryForObject(sql, new Object[] { id }, (rs, i) -> {
			// Return new person object
			return new Person(UUID.fromString(rs.getString("id")), rs.getString("name"));
		});
		return Optional.ofNullable(newPerson);
	}

	@Override
	public int deletePersonById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePersonById(UUID id, Person person) {
		// TODO Auto-generated method stub
		return 0;
	}

}
