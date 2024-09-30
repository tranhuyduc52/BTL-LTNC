package com.learnspringboot.learnspring.School;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learnspringboot.learnspring.Student.Student;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class School {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    @OneToMany(
        mappedBy = "school"
    )
    @JsonManagedReference
    private List<Student> students;
}
