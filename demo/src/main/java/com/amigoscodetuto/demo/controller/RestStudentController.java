package com.amigoscodetuto.demo.controller;

import com.amigoscodetuto.demo.domain.Student;
import com.amigoscodetuto.demo.domain.StudentDto;
import com.amigoscodetuto.demo.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/student")
public class RestStudentController {

    private final Logger log = LoggerFactory.getLogger(RestStudentController.class);
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return this.studentService.getAll();
    }

    @PostMapping
    public ResponseEntity<Map<String,Object>> getAllProducts(@RequestBody StudentDto studentDto){
        Map<String,Object> response = new HashMap<>();
        try{
            this.studentService.addNewStudent(studentDto);
            response.put("ok",true);
            response.put("msg", "student created succesfully");
//            response.put("data", );
            return ResponseEntity.ok(response);
        }catch (Exception err){
            response.put("ok", false);
            response.put("msg", "Error to creating student");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteStudent(@PathVariable("id") Long id){
        this.studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    //public void updateStudent(@PathVariable("id") Long id,@RequestBody body){
    public void updateStudent(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name, // ?name
            @RequestParam(required = false) String email // ?email
    ){
        this.studentService.updateStudent(id,name,email);
    }
}
