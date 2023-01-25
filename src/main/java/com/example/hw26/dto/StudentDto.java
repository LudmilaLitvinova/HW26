package com.example.hw26.dto;

import lombok.*;

import java.util.List;

/**
 * @author Ludmila Litvinova on 25.01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer id;

    private String name;

    private String email;

    private List<MarkDto> marks;

}
