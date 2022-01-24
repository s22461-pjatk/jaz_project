package com.example.demo.controller;


import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/student")
@RestController
public class StudentController {


    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }


    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Student> readStudents(){ return studentService.readStudents(); }


    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public String updateStudent(@RequestBody Student student){
        return studentService.updateStudent(student);
    }


    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestBody Student student){
        return studentService.deleteStudent(student);
    }
}
