package com.example.demo.model;


import javax.persistence.Id;

public class Penalty {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int hire_id;
    private float cash_penalty;

    public int getHire_id() {
        return hire_id;
    }

    public void setHire_id(int hire_id) {
        this.hire_id = hire_id;
    }

    public float getCash_penalty() {
        return cash_penalty;
    }

    public void setCash_penalty(float cash_penalty) {
        this.cash_penalty = cash_penalty;
    }
}
