package com.example.hw26.repository;

import com.example.hw26.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 * @author Ludmila Litvinova on 25.01
 */
@Slf4j
public class CustomStudentRepositoryImpl implements CustomStudentRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Student> getAllStudents() {
        log.info("call findLikeEmail");
        Query query = entityManager
                .createQuery("select s from Student s");

        return query.getResultList();
    }

    @Override
    public Student getStudentById(Integer id) {
        Student student;
        log.info("call findLikeId");
        Query query = entityManager
                .createQuery("select s from Student s where s.id = " + id);
        try {
            student = (Student) query.getSingleResult();
        } catch (NoResultException e) {
            student = null;
        }
        return student;
    }

    @Override
    public void deleteStudentById(Integer id) {
        Student student = getStudentById(id);
        if (student != null) {
            entityManager.remove(student);
        }
    }

    @Override
    public Student changeStudent(Student student) {
        student.setName("Jora");
        Query query = entityManager.createQuery("update Student set name = '" + student.getName()
                + "'");
        query.executeUpdate();
        return student;
    }
}
