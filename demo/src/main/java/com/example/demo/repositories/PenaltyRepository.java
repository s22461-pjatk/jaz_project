package com.example.demo.repositories;

import com.example.demo.model.Penalty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PenaltyRepository extends JpaRepository<Penalty, Integer> {

    public boolean existsById(int hire_id);

    @Query(value = "select max(s.penalty_id) from penalty s", nativeQuery = true)
    public Integer findMaxId();

}