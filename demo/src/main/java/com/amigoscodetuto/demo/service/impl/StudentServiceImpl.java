package com.amigoscodetuto.demo.service.impl;

import com.amigoscodetuto.demo.domain.Student;
import com.amigoscodetuto.demo.domain.StudentDto;
import com.amigoscodetuto.demo.repository.StudentRepository;
import com.amigoscodetuto.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAll() {
        /*return List.of(
                new Student(1L,"Thom","thom@gmail.com", LocalDate.of(1998, Month.APRIL,17),24)
        );*/
        return this.studentRepository.findAll();
    }

    @Override
    public void addNewStudent(StudentDto studentDto) {
        var student = new Student();
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());
        student.setName(studentDto.getName());
        this.studentRepository.save(student);
    }
}
