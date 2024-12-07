package com.GusLyud.Vodolet.repo;

import com.GusLyud.Vodolet.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT t FROM Trip t WHERE t.dateOfVoyage BETWEEN :startDate AND :endDate")
    List<Trip> findTripsByDateRange(LocalDate startDate, LocalDate endDate);
    }
