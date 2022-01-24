package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;


    @Transactional
    public String createStudent(Student student){
        try {
            if (!studentRepository.existsByEmail(student.getEmail())){
                student.setIndex_number(null == studentRepository.findMaxId()? 1 : studentRepository.findMaxId() + 1);
                studentRepository.save(student);
                return "Student record created successfully.";
            }else {
                return "Student already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
    }


    public List<Student> readStudents(){
        return studentRepository.findAll();
    }



    @Transactional
    public String updateStudent(Student student){
        if (studentRepository.existsByEmail(student.getEmail())
        ){
            try {
                List<Student> students = studentRepository.findByEmail(student.getEmail());

                students.stream().forEach(s -> {
                    Student studentToBeUpdate = studentRepository.findById(s.getIndex_number()).get();

                    if (student.getForename() != null){ studentToBeUpdate.setForename(student.getForename());
                    }
                    if (student.getName() != null){ studentToBeUpdate.setName(student.getName());
                    }
                    studentRepository.save(studentToBeUpdate);
                });
                return "Student record updated.";
            }catch (Exception e){
                throw e;
            }
        }else {
            return "Student does not exists in the database.";
        }
    }


    @Transactional
    public String deleteStudent(Student student){
        if (studentRepository.existsByEmail(student.getEmail())){
            try {
                List<Student> students = studentRepository.findByEmail(student.getEmail());
                students.stream().forEach(s -> {
                    studentRepository.delete(s);
                });
                return "Student record deleted successfully.";
            }catch (Exception e){
                throw e;
            }

        }else {
            return "Student does not exist";
        }
    }
}
