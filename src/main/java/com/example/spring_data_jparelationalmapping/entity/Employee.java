package com.example.spring_data_jparelationalmapping.entity;

import com.example.spring_data_jparelationalmapping.enums.TypeEmployee;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_id")
    private Long employeeId;

    private String emp_firstName;
    private String emp_lastName;
    private Integer emp_age;

     //pour le stocker dans la base des donnees
    @Enumerated(EnumType.STRING)
    private TypeEmployee typeEmployee;


    // un employee a une seule adrersse et vice versa
    /** si vous effectuez une opération sur l'entité parent,
     *  cette opération sera également appliquée à l'entité associée.**/
    @OneToOne(cascade = CascadeType.ALL)
    //nom de la colonne de jointure
    @JoinColumn(name = "FK_adrs_id")
    private Address address;
    /**
    @OneToMany()
    private List<Experience> experience;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="project_id")
    private Project project;
**/
    @ManyToMany
    @JoinTable(
            name="employee_mission",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "mission_id")
    )
    private Set<Mission> assignMission= new HashSet<>() ;



}
