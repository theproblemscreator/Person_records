package com.person.person.service;

import java.util.List;
import java.util.Optional;

import com.person.person.models.Person;

public interface PersonService {

	Person createPerson(Person person);
	Optional<Person> getPersonById(Long id);
	List<Person> getAllPerson();
	void deletePerson(Long id);
	Person updatePerson(Person person,Long id);
}
