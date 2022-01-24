package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Penalty {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private int penalty_id;
    private int hire_id;
    private int index_number;
    private double cash_penalty;
    private boolean paid_off;

    public int getHire_id() {
        return hire_id;
    }

    public void setHire_id(int hire_id) {
        this.hire_id = hire_id;
    }

    public double getCash_penalty() {
        return cash_penalty;
    }

    public void setCash_penalty(double cash_penalty) {
        this.cash_penalty = cash_penalty;
    }

    public int getPenalty_id() {
        return penalty_id;
    }

    public void setPenalty_id(int penalty_id) {
        this.penalty_id = penalty_id;
    }

    public int getIndex_number() {
        return index_number;
    }

    public void setIndex_number(int index_number) {
        this.index_number = index_number;
    }

    public boolean isPaid_off() {
        return paid_off;
    }

    public void setPaid_off(boolean paid_off) {
        this.paid_off = paid_off;
    }
}
