package com.person.person.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.person.models.Person;
import com.person.person.repository.PersonRepository;
import com.person.person.service.PersonService;

@RestController
@Controller
@RequestMapping("/api/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@GetMapping
	List<Person> getAllPersons(){
		return  personService.getAllPerson();
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person) {
	return personService.createPerson(person);	
	}
	
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable Long id) {
		personService.deletePerson(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Person> finById(@PathVariable Long id){
		return personService.getPersonById(id);
	}

	@PutMapping("/{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
        return personService.updatePerson(person, id);
}
}
