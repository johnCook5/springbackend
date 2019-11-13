package com.claim.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.claim.entity.Student;
import com.claim.repository.StudentRepository;


@CrossOrigin
@RestController

public class StudentController
{
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="/sign-up", consumes=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.POST)

	
	public void submitStudentDetails(@RequestBody Student student)
	{
	this.studentRepository.save(student);
	}
	
	
	@RequestMapping(value="/findByEmail", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	
	public Student findByEmail(@RequestParam String email)
	{
	
	Student student = studentRepository.findByEmail(email);
	
	return student;
	
	}
	
	@RequestMapping(value="/findStudentsByFirstName", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public List<Student> findStudentsByFirstName(@RequestParam String firstName)
	{
		List<Student> results= studentRepository.findStudentsByFirstName(firstName);
		
		return results;
	}
	
	@RequestMapping(value="/findByLastName", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public List<Student> findByLastName(@RequestParam String lastName)
	{
		List<Student> results= studentRepository.findByLastName(lastName);
		
	return results;
	}
	
	@RequestMapping(value="/login",  method=RequestMethod.GET)
	HttpStatus login(@RequestParam String email)
	{
		
		Student loogInAttempt = studentRepository.findByEmail(email);
		
		if (loogInAttempt != null)
		{
			return HttpStatus.OK;
		}
		else
		{
			return HttpStatus.NOT_FOUND;
		}
		
		
	}
	
	@RequestMapping(value="/listOfAll", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public List<Student> listOfAll()
	{
		List<Student> results= studentRepository.findAll();
				
				return results;
	}
	
	@RequestMapping(value="/findStudentById", produces=MediaType.APPLICATION_JSON_VALUE, method=RequestMethod.GET)
	public ResponseEntity<Optional<Student>> findById(String email)
	{
		Optional <Student> student = this.studentRepository.findById(email);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
		
}

