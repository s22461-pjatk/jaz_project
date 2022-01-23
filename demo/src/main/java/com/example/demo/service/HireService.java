package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Book;
import com.example.demo.model.Hire;
import com.example.demo.repositories.BookRepository;
import com.example.demo.repositories.HireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Component
public class HireService {

    private HireRepository hireRepository;

    @Autowired
    public HireService(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }

    public List<Hire> readHires(){
        return hireRepository.findAll();
    }

    public List<Hire> readStudentHires(int index_number){return hireRepository.findStudentHiresById(index_number);}


    @Transactional
    public String createHire(Hire hire){
        try {
            if (!hireRepository.existsById(hire.getHire_id())){
                hire.setHire_id(null == hireRepository.findMaxId()? hire.getHire_id() : hireRepository.findMaxId() + 1);
                hireRepository.save(hire);
                return "Hire record created successfully.";
            }else {
                return "Hire already exists in the database.";
            }
        }catch (Exception e){
            throw e;
        }
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
