package com.learnspringboot.learnspring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.learnspringboot.learnspring.School.*;
import com.learnspringboot.learnspring.Service.SchoolService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class SchoolController {
    private final SchoolService schoolService;
    public SchoolController(SchoolService schoolService){
        this.schoolService=schoolService;
    }

    @PostMapping("/schools")
    public SchoolDto addSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.addSchool(schoolDto);
    }
    @GetMapping("/schools")
    public List<SchoolDto> findAll() {
        return schoolService.findAll();
    }
    
}
