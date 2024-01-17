package com.example.spring_data_jparelationalmapping.controller;

import com.example.spring_data_jparelationalmapping.entity.Employee;
import com.example.spring_data_jparelationalmapping.entity.Mission;
import com.example.spring_data_jparelationalmapping.entity.Project;
import com.example.spring_data_jparelationalmapping.mapper.EmployeeDTO;
import com.example.spring_data_jparelationalmapping.repository.EmployeeRepo;
import com.example.spring_data_jparelationalmapping.repository.MissionRepo;
import com.example.spring_data_jparelationalmapping.response.EmployeResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
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
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        this.employeeRepo.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
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

}
