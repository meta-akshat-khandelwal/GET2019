package com.metacube.EADAssignment8.repository;
/**
 * user defined interface that extends JpaRepository
 * @author Akshat
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.EADAssignment8.model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

	Admin findById(String id);

}
