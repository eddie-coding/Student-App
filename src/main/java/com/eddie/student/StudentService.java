package com.eddie.student;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eddie.EmailValidator;
import com.eddie.exception.ApiRequestException;

@Service
public class StudentService {

    private final StudentDataAccessService studentDataAccessService;
    private final EmailValidator emailValidator;

    @Autowired
    public StudentService(StudentDataAccessService studentDataAccessService, EmailValidator emailValidator) {
        this.studentDataAccessService = studentDataAccessService;
        this.emailValidator = emailValidator;
    }

    List<Student> getAllStudents() {
        return studentDataAccessService.getAllStudents();
    }

    void addNewStudent(Student student) {
        addNewStudent(null, student);
    }

    void addNewStudent(UUID studentId, Student student) {
        UUID newStudentId = Optional.ofNullable(studentId).orElse(UUID.randomUUID());

        if (!emailValidator.test(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " is not valid");
        }

        if (studentDataAccessService.isEmailTaken(student.getEmail())) {
            throw new ApiRequestException(student.getEmail() + " is taken");
        }

        studentDataAccessService.insertStudent(newStudentId, student);
    }   
}
