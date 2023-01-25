package com.example.hw26.repository;

import com.example.hw26.model.Student;

import java.util.List;

/**
 * @author Ludmila Litvinova on 25.01
 */
public interface CustomStudentRepository {
    List<Student> getAllStudents();

    Student getStudentById(Integer id);

    void deleteStudentById(Integer id);

    Student changeStudent(Student student);
}
