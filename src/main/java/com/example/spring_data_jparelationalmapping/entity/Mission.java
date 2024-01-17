package com.example.spring_data_jparelationalmapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(mappedBy = "assignMission")
    private Set<Employee> assignEmployees = new HashSet<>();
}
