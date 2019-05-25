package com.letsstartcoding.springbootrestapiexample;

import com.letsstartcoding.springbootrestapiexample.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}