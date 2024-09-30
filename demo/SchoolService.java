package com.learnspringboot.learnspring.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.learnspringboot.learnspring.School.SchoolDto;
import com.learnspringboot.learnspring.School.SchoolMapper;
import com.learnspringboot.learnspring.School.SchoolRepository;

@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final SchoolMapper schoolMapper;
    public SchoolService(SchoolRepository repository,SchoolMapper schoolMapper){
        this.repository=repository;
        this.schoolMapper=schoolMapper;
    }
    public SchoolDto addSchool(SchoolDto schoolDto) {
        repository.save(schoolMapper.toSchool(schoolDto));
        return schoolDto;
    }
    public List<SchoolDto> findAll() {
        return repository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toList());
    }
}
