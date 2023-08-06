package com.eddie.student;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class StudentController {

    @GetMapping
    public List<Student> getAllStudents() {

        return List.of(
            new Student(UUID.randomUUID(), "Aditya", "Bahuguna", "adityabahuguna007@gmail.com", Student.Gender.MALE),
            new Student(UUID.randomUUID(), "Rohit", "Bisht", "rohitbisht@gmail.com", Student.Gender.MALE)
        );
    }   
}
