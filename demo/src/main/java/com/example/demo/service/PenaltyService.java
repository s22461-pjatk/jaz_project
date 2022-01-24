package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Penalty;
import com.example.demo.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PenaltyService {

    private BookRepository bookRepository;
    private BookCollectionRepository bookCollectionRepository;
    private PenaltyRepository penaltyRepository;
    private HireRepository hireRepository;
    private StudentRepository studentRepository;


    public int date_division(int days){
        Date data = hireRepository.penaltyDate(1);
        days = (int) ((System.currentTimeMillis() - data.getTime()) / (24*60*60*1000));
        return (days >= 1? days: 0);
    }


    @Autowired
    public PenaltyService(BookRepository bookRepository, BookCollectionRepository bookCollectionRepository, PenaltyRepository penaltyRepository,
        HireRepository hireRepository, StudentRepository studentRepository) {

        this.bookRepository = bookRepository;
        this.bookCollectionRepository = bookCollectionRepository;
        this.penaltyRepository = penaltyRepository;
        this.hireRepository = hireRepository;
        this.studentRepository = studentRepository;
    }

    public List<Penalty> readPenalties(){ return penaltyRepository.findAll(); }


    @Transactional
    public String createPenalty(Penalty penalty) {
        if (hireRepository.existsById(penalty.getHire_id())
                & studentRepository.existsById(penalty.getIndex_number())
                & hireRepository.findStudentHiresById(penalty.getIndex_number()).size() != 0
        ) {
            int days = date_division(penalty.getIndex_number());


            double to_paid = (2.5 * days);
            penalty.setPaid_off((penalty.isPaid_off() ? true : false));
            penalty.setCash_penalty(to_paid);
            penalty.setPenalty_id(null == penaltyRepository.findMaxId() ? 1 : penaltyRepository.findMaxId() + 1);
            penaltyRepository.save(penalty);


            return "book record created successfully.";

        } else {

            SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");


            //Date now = new java.sql.Date()

            return "book already exists in the database.";
            }

        }


        @Transactional
        public String deletePenalty(Penalty penalty) {
            if (penaltyRepository.existsById(penalty.getPenalty_id())) {
            try {
                Optional<Penalty> penalties = penaltyRepository.findById(penalty.getPenalty_id());
                penalties.stream().forEach(s -> {
                    penaltyRepository.delete(s);
                });
                return "Penalty record deleted successfully.";
            } catch (Exception e){
                throw e;
            }

        } else {
        return "Penalty does not exist";
    }

        }
}
