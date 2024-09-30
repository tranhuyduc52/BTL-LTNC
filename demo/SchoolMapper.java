package com.learnspringboot.learnspring.School;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {


    public School toSchool(SchoolDto schoolDto){
        School school = new School();
        school.setName(schoolDto.name());
        return school;
    }
    public SchoolDto toSchoolDto(School school){
        return new SchoolDto(school.getName());
    }
}
