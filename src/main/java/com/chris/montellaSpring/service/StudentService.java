package com.chris.montellaSpring.service;

import com.chris.montellaSpring.model.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>();
    @Autowired
    public ObservationRegistry observationRegistry;

    public Student addStudent(Student student) {
        students.add(student);
        //
        return Observation.createNotStarted("add student",observationRegistry)
                .observe(()->student);
    }

    public List<Student> getAllStudents() {
        return Observation.createNotStarted("getStudents",observationRegistry)
                .observe(()->students);
    }

    public Student getStudent(String id) {
        return Observation.createNotStarted("getStudent",observationRegistry)
                .observe(()->students.stream()
                .filter(student -> student.id().equals(id))
                .findFirst()
                .orElseThrow(()->new RuntimeException("student is not available")));
    }
}
