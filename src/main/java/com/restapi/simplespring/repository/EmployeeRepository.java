package com.restapi.simplespring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.simplespring.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
