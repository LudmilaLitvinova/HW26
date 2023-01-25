package com.example.hw26.service;

import com.example.hw26.dto.StudentDto;
import com.example.hw26.model.Mark;
import com.example.hw26.model.Student;
import com.example.hw26.repository.MarkRepository;
import com.example.hw26.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Ludmila Litvinova on 25.01
 */
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final MarkRepository markRepository;
    private final ObjectMapper objectMapper;

    public StudentDto createStudent(StudentDto studentDto) {
        Student student = objectMapper.convertValue(studentDto, Student.class);
        studentRepository.save(student);
        studentDto.setId(student.getId());


        List<Mark> marks = studentDto.getMarks().stream().map(p -> objectMapper.convertValue(p, Mark.class)).toList();
        for (Mark m : marks) {
            m.setStudent(student);
            markRepository.save(m);
        }

        student.setMarks(marks);

        return studentDto;
    }

    public List<StudentDto> getAllStudents() {
        List<StudentDto> students = studentRepository.getAllStudents().stream().map(p -> objectMapper.convertValue(p, StudentDto.class)).toList();
        return students;
    }
    public StudentDto getStudentById(int id){
        Student studentById = studentRepository.getStudentById(id);
        if (studentById!= null){
        StudentDto student = objectMapper.convertValue(studentById, StudentDto.class);
            return student;
        }else {
            return null;
        }

    }

    public StudentDto changeStudent(StudentDto studentDto){
        Student student = objectMapper.convertValue(studentDto,Student.class);
        return objectMapper.convertValue(studentRepository.changeStudent(student), StudentDto.class);
    }

    public void deleteStudentById(Integer id){
        studentRepository.deleteStudentById(id);
    }
}
