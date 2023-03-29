package com.amigoscodetuto.demo.service.impl;

import com.amigoscodetuto.demo.domain.Student;
import com.amigoscodetuto.demo.domain.StudentDto;
import com.amigoscodetuto.demo.repository.StudentRepository;
import com.amigoscodetuto.demo.service.StudentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
        Optional<Student> studentByEmail =  this.studentRepository.findStudentByEmail(studentDto.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        var student = new Student();
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setAge(studentDto.getAge());
        student.setEmail(studentDto.getEmail());
        student.setName(studentDto.getName());
        this.studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        var exists = this.studentRepository.existsById(id);
        if(!exists) throw  new IllegalStateException("student with id "+id+" does not exists");
        this.studentRepository.deleteById(id);
    }

    // indica que el método debe ser ejecutado en una transacción, lo que significa que si algo falla durante la ejecución del método, se realiza un rollback
    @Override
    @Transactional
    public void updateStudent(Long id, String name, String email) {
        var student = this.studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("student with id \"+id+\" does not exists"));
        if(name != null && name.trim().length() > 0 && !Objects.equals(student.getName(),name)) {
            student.setName(name);
        }

        if(email != null && email.trim().length() > 0 && !Objects.equals(student.getEmail(),email)) {
            Optional<Student> studentOptional = this.studentRepository.findStudentByEmail(email);
            if(studentOptional.isPresent()){
                throw  new IllegalStateException("email token");
            }
            student.setEmail(email);
        }

        // esto no es necesario por el Transactionl this.studentRepository.save(student);

//        Spring sabe que debe hacer un update porque cuando se llama al método save() del repositorio y se le pasa una entidad que ya tiene un id asignado, Spring lo interpreta como una actualización de la entidad existente en la base de datos. Por lo tanto, si se llama al método save() con una entidad que ya existe en la base de datos, Spring automáticamente realizará una actualización en lugar de insertar una nueva fila.
    }
}
