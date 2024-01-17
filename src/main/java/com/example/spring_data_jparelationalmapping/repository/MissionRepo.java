package com.example.spring_data_jparelationalmapping.repository;

import com.example.spring_data_jparelationalmapping.entity.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MissionRepo extends JpaRepository<Mission,Long> {

}
