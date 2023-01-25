package com.example.hw26.repository;

import com.example.hw26.model.Mark;
import com.example.hw26.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ludmila Litvinova on 25.01
 */
public interface MarkRepository extends JpaRepository<Mark, Integer>{

}
