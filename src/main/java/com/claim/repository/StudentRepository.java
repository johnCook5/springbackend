package com.claim.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.claim.entity.Student;
@Repository

public interface StudentRepository extends JpaRepository<Student, String>
{
	Student findByEmail(String email);
	
	
	@Query("Select S From Student S where S.firstName=:firstName")
	List<Student> findStudentsByFirstName(@Param("firstName")String firstName);
	
	@Query("Select S From Student S where S.lastName=:lastName")
	List<Student> findByLastName(String lastName);
	
	
	
	
}
