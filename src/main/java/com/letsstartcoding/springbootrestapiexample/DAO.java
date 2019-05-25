package com.letsstartcoding.springbootrestapiexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DAO {

    @Autowired
    EmployeeRepository employeeRepository;

    /* to save an employee*/
    public Employee save(Employee emp){
        return employeeRepository.save(emp);

    }

    /*search an employee*/
    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    /*get an employee by id*/

    public Employee findOne(long empid){
        return employeeRepository.findOne(empid);

    }
    /*delete an employee*/

    public void delete (Employee emp){
        employeeRepository.delete(emp);

    }
}
