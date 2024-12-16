package com.GusLyud.Vodolet.repo;

import com.GusLyud.Vodolet.models.Trip;
import com.GusLyud.Vodolet.models.TripHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TripHistoryRepository extends JpaRepository<TripHistory, Long> {
    @Query("SELECT t FROM TripHistory t WHERE t.dateOfVoyage BETWEEN :startDate AND :endDate")
    List<TripHistory> findTripsByDateRange(LocalDate startDate, LocalDate endDate);

    @Query("SELECT t FROM TripHistory t WHERE t.dateOfVoyage BETWEEN :startDate AND :endDate AND t.roadMap = :roadMap")
    List<TripHistory> findByDateRangeAndRoadMap(LocalDate startDate, LocalDate endDate, String roadMap);

    @Query("SELECT t FROM TripHistory t WHERE t.roadMap = :roadMap")
    List<TripHistory> findByRoadMap(String roadMap);

}
