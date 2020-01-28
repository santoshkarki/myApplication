package com.example.myApplication.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor                  //empty constructor generation from Lombok Project
@AllArgsConstructor                 //constructor with all arguments generation from Lombok Project
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "course")
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COURSE_ID", nullable = false)
    private int id;

    @Column(name="COURSE_NAME", unique = true, nullable = false)
    private String name;

    @Column(name="COURSE_DESCRIPTION", unique = true, nullable = false)
    private String descriptions;

    @ElementCollection
    private List<String> steps;

}











/*
* '@NoArgsConstructor' will generate a constructor with no parameters.
* '@RequiredArgsConstructor' generates a constructor with 1 parameter for each field that requires special handling.
* '@AllArgsConstructor' generates a constructor with 1 parameter for each field in your class
* */