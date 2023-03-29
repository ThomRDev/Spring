package com.amigoscodetuto.demo.service;

import com.amigoscodetuto.demo.domain.Student;
import com.amigoscodetuto.demo.domain.StudentDto;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    void addNewStudent(StudentDto student);

    void deleteStudent(Long id);


    void updateStudent(Long id,String name,String email);
}
