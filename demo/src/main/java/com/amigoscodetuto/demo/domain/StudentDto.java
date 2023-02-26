package com.amigoscodetuto.demo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) // si tiene valores en null no se mandaran
@NoArgsConstructor
public class StudentDto {
    private Long id;

    private String name;
    private String email;
    private LocalDate dateOfBirth;

    private Integer age;

    public StudentDto(Student student){
        this.id = student.getId();
        this.age = student.getAge();
        this.name = student.getName();
        this.dateOfBirth = student.getDateOfBirth();
        this.email = student.getEmail();
    }
}
