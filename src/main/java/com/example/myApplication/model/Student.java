package com.example.myApplication.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter
@ToString @EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student",catalog = "myapplication")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="STUDENT_ID", unique = true, nullable = false)
    private int id;

    @Column(name="STUDENT_NAME", unique = true, nullable = false)
    private String name;

    @Column(name="STUDENT_DESCRIPTION",  nullable = false)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE", joinColumns = { @JoinColumn(name = "STUDENT_ID") }, inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
    private Set<Course> courses = new HashSet<>(0);


}

