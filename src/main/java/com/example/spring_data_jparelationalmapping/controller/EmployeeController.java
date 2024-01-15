package com.example.spring_data_jparelationalmapping.controller;

import com.example.spring_data_jparelationalmapping.entity.Employee;
import com.example.spring_data_jparelationalmapping.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody List<Employee> employee){
        //saveAll() pour enregistrer plusieurs entites
         employeeRepo.saveAll(employee);
         return ResponseEntity.ok("employee saved !");
    }

    @GetMapping("getEmployeeId/{id}")
    public  ResponseEntity<Employee> getEmployee(@PathVariable Long id){

        Employee employee = employeeRepo.findById(id).orElse(null);

        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }



}
