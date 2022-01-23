package com.example.demo.controller;


import com.example.demo.model.Hire;
import com.example.demo.service.HireService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RequestMapping("api/hire")
@RestController
public class HireController {

    @Autowired
    private HireService hireService;


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createHire(@RequestBody Hire hire){
        return hireService.createHire(hire);
    }


    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Hire> readHires(){
        return hireService.readHires();

    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deleteHire(@RequestBody Hire hire){
        return hireService.deleteHire(hire);
    }


    @RequestMapping(value = "studentHires/{id}", method = RequestMethod.GET)
    public List<Hire> readStudentHiresByID(@PathVariable("id") int id){
        return hireService.readStudentHires(id);
    }



}


