package com.example.demo.repositories;

import com.example.demo.model.Hire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HireRepository extends JpaRepository<Hire, Integer> {

    public boolean existsById(int hire_id);

    @Query(value = "select max(s.hire_id) from hire s", nativeQuery = true)
    public Integer findMaxId();

    @Query(value = "select * from hire where index_number = ?1", nativeQuery = true)
    public List<Hire> findStudentHiresById(int index_number);

}