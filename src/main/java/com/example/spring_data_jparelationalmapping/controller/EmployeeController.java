package com.example.spring_data_jparelationalmapping.controller;

import com.example.spring_data_jparelationalmapping.entity.Employee;
import com.example.spring_data_jparelationalmapping.entity.Mission;
import com.example.spring_data_jparelationalmapping.entity.Project;
import com.example.spring_data_jparelationalmapping.mapper.EmployeeDTO;
import com.example.spring_data_jparelationalmapping.repository.EmployeeRepo;
import com.example.spring_data_jparelationalmapping.repository.MissionRepo;
import com.example.spring_data_jparelationalmapping.response.EmployeResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@Slf4j
@RequestMapping("api/")
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private MissionRepo missionRepo;
/**
    @PostMapping("saveEmployee")
    public EmployeResponseDTO saveEmployee(@RequestBody EmployeeDTO dto){
        //saveAll() pour enregistrer plusieurs entites
        var employeDto = ToEmployee(dto);

         var savedemployee =  employeeRepo.save(employeDto);
         return toEmployeeResponseDTO(savedemployee);
    }
    private Employee ToEmployee(EmployeeDTO dto){
     var  employee = new Employee();
     employee.setEmp_firstName(dto.Fname());
     employee.setEmp_lastName(dto.Lname());

     var project = new Project();
     project.setIdProject(dto.projectId());

     employee.setProject(project);

     return employee;

    }

    private EmployeResponseDTO toEmployeeResponseDTO(Employee employee){
        return  new EmployeResponseDTO(
                employee.getEmp_firstName(),
                employee.getEmp_lastName()
        );
    }
**/

    @PostMapping("saveEmployee")
    public Employee addEmployee(@RequestBody Employee employee){

        log.info("Endpoint '...' (POST) finished");

        return this.employeeRepo.save(employee);
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

    @PutMapping("employId/{idEmp}/{MissionId}")
    public Employee asssignMissionToEmploye(@PathVariable  Long idEmp, @PathVariable Long idMiss){
        Set<Mission> missionSet = null;
        Employee employee = employeeRepo.findById(idEmp).get();
        Mission mission = missionRepo.findById(idMiss).get();
        missionSet = employee.getAssignMission();
        missionSet.add(mission);
        employee.setAssignMission(missionSet);
        return employeeRepo.save(employee);

    }

    @GetMapping("getAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeRepo.findAll();
    }

    @PutMapping("updateEmp/{id}")
    public Employee updateEmp(@PathVariable Long id, @RequestBody Employee employee){
        employee.setEmployeeId(id);
        return employeeRepo.save(employee);
    }

    @DeleteMapping("deleteEmp/{id}")
    public void deleteEmp(@PathVariable Long id){
        employeeRepo.deleteById(id);
    }
}
