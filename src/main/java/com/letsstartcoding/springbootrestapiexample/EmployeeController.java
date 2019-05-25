package com.letsstartcoding.springbootrestapiexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")

public class EmployeeController {
     @Autowired
     DAO EmployeeDAO;

    /* save an employee */
    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee emp) {
        return EmployeeDAO.save(emp);

    }
    /* get all employees*/
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return EmployeeDAO.findAll();

    }
    /*get employee by id */

    @GetMapping("/notes/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid){
        Employee emp=EmployeeDAO.findOne(empid);
        if(emp==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(emp);
    }
    /*update an employee by id */
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid,@Valid @RequestBody Employee empDetails){
        Employee emp=EmployeeDAO.findOne(empid);
        if(emp==null)
            return ResponseEntity.notFound().build();
        emp.setName(empDetails.getName());
        emp.setDesignation(empDetails.getDesignation());
        emp.setExpertise(empDetails.getExpertise());
        Employee updateEmployee=EmployeeDAO.save(emp);
        return ResponseEntity.ok().body(updateEmployee);
    }
    /*Delete an employee */
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empid){
        Employee emp=EmployeeDAO.findOne(empid);
        if(emp==null)
            return ResponseEntity.notFound().build();
        EmployeeDAO.delete(emp);
        return ResponseEntity.ok().build();

    }

}
