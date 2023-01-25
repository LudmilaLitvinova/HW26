package com.example.hw26;

import com.example.hw26.dto.MarkDto;
import com.example.hw26.dto.StudentDto;
import com.example.hw26.repository.StudentRepository;
import com.example.hw26.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Ludmila Litvinova on 25.01
 */
@SpringBootApplication
public class Hw26Application {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Hw26Application.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void init() {


        List<MarkDto> listMarkDto = new ArrayList<>();
        MarkDto markMath = new MarkDto(null, "Algebra", 12, null);
        MarkDto markChem = new MarkDto(null, "Chemestry", 8, null);


        listMarkDto.add(markMath);
        listMarkDto.add(markChem);

        StudentDto studentDto = new StudentDto(null, "Petrovich", "oboltus@gmail.com", listMarkDto);

        studentService.createStudent(studentDto);

        System.out.println(studentService.getAllStudents());

        System.out.println(studentService.getStudentById(13));

        System.out.println(studentService.changeStudent(studentDto));

        studentService.deleteStudentById(4);

    }

}
