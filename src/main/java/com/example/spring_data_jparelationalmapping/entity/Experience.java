package com.example.spring_data_jparelationalmapping.entity;

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
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_expr")
    private Long idExperience;
    private String compagnies;
    private String profession;
/**
    @ManyToOne
    @JoinColumn(name = "FK_id_emp")
    private Employee employee;**/
}
