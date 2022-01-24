package com.example.demo.controller;


import com.example.demo.model.Penalty;
import com.example.demo.service.PenaltyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/penalty")
@RestController
public class PenaltyController {


    private PenaltyService penaltyService;


    @Autowired
    public PenaltyController(PenaltyService penaltyService) {
        this.penaltyService = penaltyService;
    }


    @RequestMapping(value = "read", method = RequestMethod.GET)
    public List<Penalty> readHires(){ return penaltyService.readPenalties(); }


    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String createPenalty(@RequestBody Penalty penalty){ return penaltyService.createPenalty(penalty); }


    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public String deletePenalty(@RequestBody Penalty penalty){
        return penaltyService.deletePenalty(penalty);
    }



}
