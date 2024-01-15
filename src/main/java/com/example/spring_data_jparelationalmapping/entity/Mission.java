package com.example.spring_data_jparelationalmapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="mission_id")
    private Long missionId;

    private String name_mission;

    @ManyToMany(mappedBy = "missions")
    private List<Employee> employees;
}
