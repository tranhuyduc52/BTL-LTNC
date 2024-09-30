package com.learnspringboot.learnspring.Controller;

import java.util.List;
import java.util.HashMap;

import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.learnspringboot.learnspring.Service.StudentService;
import com.learnspringboot.learnspring.Student.*;

import jakarta.validation.Valid;


@RestController
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping("/student/{student-id}")
    public StudentResponseDto getStudentById(@PathVariable("student-id") Integer id) {
        return studentService.getStudentById(id);
    }
    @GetMapping("/search/{student-name}")
    public List<StudentResponseDto> getStudentByFirstname(@PathVariable("student-name") String firstname) {
        return studentService.getStudentByFirstname(firstname);
    }


    @PostMapping("/students")
    public StudentResponseDto addStudent(@Valid @RequestBody StudentDTO studentdto) {
        return studentService.addStudent(studentdto);
    }

    
    @DeleteMapping("/students/{student-id}")
    public void delete(@PathVariable("student-id") int id){
        studentService.deleteById(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex)
    {
        var errors = new HashMap<String,String>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            var fieldname=((FieldError)error).getField();
            var message=error.getDefaultMessage();
            errors.put(fieldname,message);
        });
        return new ResponseEntity<>(errors,HttpStatus.BAD_REQUEST);
    }
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public String handlError(MethodArgumentNotValidException e){
    //     return e.getBindingResult().getFieldError().getField();
    // }

}
