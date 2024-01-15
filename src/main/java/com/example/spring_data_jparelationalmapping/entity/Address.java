package com.example.spring_data_jparelationalmapping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="adrs_id")
    private Long addressId;
    private String city;
    private String addressType;

    @OneToOne
    @JoinColumn(name ="FK_id_employee")
    private Employee employee;

}
