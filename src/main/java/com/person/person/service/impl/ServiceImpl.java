package com.person.person.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.person.person.models.Person;
import com.person.person.repository.PersonRepository;
import com.person.person.service.PersonService;

@Service
public class ServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public Person createPerson(Person person) {

		if (personRepository.findByEmail(person.getEmail()).isPresent()) {
			throw new RuntimeException("Email already exists");
		}
		try {
			return personRepository.save(person);
		} catch (DataIntegrityViolationException e) {
			throw new RuntimeException("Email or username already exists");
		}
	}

	@Override
	public Optional<Person> getPersonById(Long id) {
		return personRepository.findById(id);
	}

	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();

	}

	@Override
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}

	@Override
	public Person updatePerson(Person person, Long id) {
		Optional<Person> existingPerson = personRepository.findById(id);
		if (existingPerson.isPresent()) {
			return personRepository.save(person);
		}
		return null;
	}

}
