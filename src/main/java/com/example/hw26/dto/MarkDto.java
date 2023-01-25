package com.example.hw26.dto;

import com.example.hw26.model.Student;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;

/**
 * @author Ludmila Litvinova on 25.01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MarkDto {

    private Integer id;

    private String discipline;

    private Integer value;

    @OneToOne
    @JoinColumn(name = "fk_student_id", nullable = false)
    private Student student;
}
