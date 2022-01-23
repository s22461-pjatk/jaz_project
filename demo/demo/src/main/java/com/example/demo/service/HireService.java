package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Book;
import com.example.demo.model.Hire;
import com.example.demo.repositories.BookCollectionRepository;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.HireRepository;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class HireService {

    private HireRepository hireRepository;
    private BookRepository bookRepository;
    private StudentRepository studentRepository;
    private BookCollectionRepository bookCollectionRepository;


    @Autowired
    public HireService(HireRepository hireRepository, BookRepository bookRepository,
                       StudentRepository studentRepository, BookCollectionRepository bookCollectionRepository) {
        this.hireRepository = hireRepository;
        this.bookRepository = bookRepository;
        this.studentRepository = studentRepository;
        this.bookCollectionRepository = bookCollectionRepository;


    }


    public List<Hire> readHires(){
        return hireRepository.findAll();
    }

    public List<Hire> readStudentHires(int index_number){return hireRepository.findStudentHiresById(index_number);}


    @Transactional
    public String createHire(Hire hire){
        if ( studentRepository.existsById(hire.getIndex_number())
        & bookRepository.existsById(hire.getBook_id())
        & hire.getHire_id() == 0
        ){

            Date hire_date = new java.sql.Date(System.currentTimeMillis());
            Date delivery_date = new java.sql.Date(System.currentTimeMillis() + 14*24*3600*1000);

            hire.setDate_hire(hire_date);
            hire.setDate_delivery(delivery_date);

            hireRepository.save(hire);

            return "Hire record created successfully.";
        }

        return "Hire loan has not been added.";


    }




    @Transactional
    public String deleteHire(Hire hire) {
        if (hireRepository.existsById(hire.getHire_id())) {
            try {
                Optional<Hire> hires = hireRepository.findById(hire.getHire_id());
                hires.stream().forEach(s -> {
                    hireRepository.delete(s);
                });
                return "Hire record deleted successfully.";
            } catch (Exception e) {
                throw e;
            }

        } else {
            return "Hire does not exist";
        }
    }
}
