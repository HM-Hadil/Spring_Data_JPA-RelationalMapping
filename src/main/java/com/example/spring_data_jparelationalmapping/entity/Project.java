package com.example.spring_data_jparelationalmapping.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_project")
    private Long idProject;

    private String name_proj;
    private String descrp_proj;
/**
    @OneToMany(mappedBy = "project")
    private List<Employee> employees;**/
}
