package com.eddie.student;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public List<Student> getAllStudents() {

        return List.of(
            new Student(UUID.randomUUID(), "Aditya", "Bahuguna", "adityabahuguna007@gmail.com", Student.Gender.MALE),
            new Student(UUID.randomUUID(), "Rohit", "Bisht", "rohitbisht@gmail.com", Student.Gender.MALE)
        );
    }   
    
}
