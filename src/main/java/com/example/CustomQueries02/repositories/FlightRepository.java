package com.example.CustomQueries02.repositories;

import com.example.CustomQueries02.entities.Flight;

import com.example.CustomQueries02.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByStatus(Status status);

    @Query(value = "SELECT * FROM flight AS f WHERE f.status =:p1 OR f.status=:p2", nativeQuery = true)
    List<Flight> findByTwoStatus(@Param("p1") String p1, @Param("p2") String p2);
}