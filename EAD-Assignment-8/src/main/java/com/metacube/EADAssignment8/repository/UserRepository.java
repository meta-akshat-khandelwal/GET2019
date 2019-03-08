package com.metacube.EADAssignment8.repository;
/**
 * user defined interface that extends JpaRepository
 * and CrudRepository
 * @author Akshat
 */

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metacube.EADAssignment8.model.User;


@Repository
public interface UserRepository<U> extends JpaRepository<User, Integer>, CrudRepository<User, Integer> {
	
	
	List<User> findByEmail(String value);

	List<User> findById(int id);
	
	@Query("select u from User u where u.first_name = :first_name")
	List<User> findByFirstName(@Param("first_name")String first_name);

	@Query("select u from User u where u.last_name = :last_name")
	List<User> findByLastName(@Param("last_name")String last_name);
	
	@Query("select u from User u where u.contact_number = :contact_number")
	List<User> findByContactNumber(@Param("contact_number")String contact_number);
	
	

}
