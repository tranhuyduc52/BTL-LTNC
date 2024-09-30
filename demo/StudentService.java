package com.learnspringboot.learnspring.Service;

import java.util.List;
import java.util.stream.Collectors;

//import org.hibernate.mapping.Collection;
//import org.hibernate.internal.util.type.PrimitiveWrapperHelper.IntegerDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learnspringboot.learnspring.Student.Student;
import com.learnspringboot.learnspring.Student.StudentDTO;
import com.learnspringboot.learnspring.Student.StudentMapper;
import com.learnspringboot.learnspring.Student.StudentRepository;
import com.learnspringboot.learnspring.Student.StudentResponseDto;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository repository,StudentMapper studentMapper){
        this.repository=repository;
        this.studentMapper=studentMapper;
    }
    public StudentResponseDto addStudent(StudentDTO studentDTO){
        var student = studentMapper.toStudent(studentDTO);
        repository.save(student);
        return studentMapper.toStudentResponseDto(student);
    }
    public List<StudentResponseDto> getAllStudents(){
        return repository.findAll()
        .stream()
        .map(studentMapper::toStudentResponseDto)
        .collect(Collectors.toList());
    }
    public StudentResponseDto getStudentById(int id){
        return repository.findById(id)
        .map(studentMapper::toStudentResponseDto)
        .orElse(null);
    }
    public List<StudentResponseDto> getStudentByFirstname(String firstname){
        return repository.findAllByFirstnameContaining(firstname)
        .stream()
        .map(studentMapper::toStudentResponseDto)
        .collect(Collectors.toList());
    }
    public void deleteById(int id){
        repository.deleteById(id);
    }
}
