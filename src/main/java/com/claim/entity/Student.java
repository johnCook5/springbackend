package com.claim.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.claim.repository.StudentRepository;

@Entity
@Table(name="student")
public class Student
{
	@Id
	@Column(name="email")
	private String email;
	
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="telephone")
	private String telephone;
	
	public Student()
	{
		
	}
	
	public Student(String email, String firstName, String lastName, int age, String telephone)
	{
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.telephone = telephone;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getTelephone()
	{
		return telephone;
	}

	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	
	
	
	
	
	

}
