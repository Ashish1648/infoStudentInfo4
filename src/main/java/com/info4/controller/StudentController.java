package com.info4.controller;

import com.info4.Dto.StudentDto;
import com.info4.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping
    public ResponseEntity<StudentDto>CreateStudent(@RequestBody StudentDto studentDto){
        StudentDto resultDto = studentService.createStudent(studentDto);
        return new ResponseEntity<>(resultDto, HttpStatus.CREATED);
    }
    //url=http://localhost:8080/api/students/1
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto>FindStudentById(@PathVariable("id")long id){
        StudentDto dataById = studentService.findDataById(id);
        return ResponseEntity.ok(dataById);
    }
}
