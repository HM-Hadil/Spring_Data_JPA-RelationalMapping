package com.example.spring_data_jparelationalmapping.controller;

import com.example.spring_data_jparelationalmapping.entity.Mission;
import com.example.spring_data_jparelationalmapping.repository.MissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MissionController {
@Autowired
private MissionRepo missionRepo;

    @PostMapping("addMission")
    public ResponseEntity saveMission(@RequestBody Mission mission){
        missionRepo.save(mission);
        return  new ResponseEntity(HttpStatus.CREATED);

    }

    @GetMapping("getMission/{idMiss}")
    public Optional<Mission> getMission(  @PathVariable Long idMiss){
        if (idMiss == null) {
            throw new IllegalArgumentException("The given id must not null !!!!!!!!!");
        }
            return missionRepo.findById(idMiss);


    }

    @GetMapping("getAllMission")
    public List<Mission> getAllMission(){
        return missionRepo.findAll();
    }

}
