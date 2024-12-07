package com.GusLyud.Vodolet.repo;

import com.GusLyud.Vodolet.models.TripHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripHistoryRepository extends JpaRepository<TripHistory, Long> {

}
