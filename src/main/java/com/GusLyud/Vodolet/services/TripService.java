package com.GusLyud.Vodolet.services;

import com.GusLyud.Vodolet.models.Trip;
import com.GusLyud.Vodolet.models.TripHistory;
import com.GusLyud.Vodolet.repo.BoatRepository;
import com.GusLyud.Vodolet.repo.TripHistoryRepository;
import com.GusLyud.Vodolet.repo.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TripHistoryRepository tripHistory;
    private final BoatRepository boatRepository;

    @Autowired

    public TripService(TripRepository tripRepository, TripHistoryRepository tripHistory, BoatRepository boatRepository) {
        this.tripRepository = tripRepository;
        this.tripHistory = tripHistory;
        this.boatRepository = boatRepository;
    }

    public List<Trip> getAllTrips(){
        return tripRepository.findAll();
    }
    public List<TripHistory> getAllHistoryTrips(){
        return tripHistory.findAll();
    }

    public List<Trip> getTripsByDateRange(String startDate, String endDate) {
        return tripRepository.findByDateRange(LocalDate.parse(startDate), LocalDate.parse(endDate));
    }

    public List<Trip> getTripsByRoadMap(String roadMap) {
        return tripRepository.findByRoadMap(roadMap);
    }

    public List<Trip> getTripsByDateRangeAndRoadMap(String startDate, String endDate, String roadMap) {
        return tripRepository.findByDateRangeAndRoadMap(LocalDate.parse(startDate), LocalDate.parse(endDate), roadMap);
    }

    public List<TripHistory> getTripsHistoryByDateRangeAndRoadMap(String startDate, String endDate, String roadMap) {
        return tripHistory.findByDateRangeAndRoadMap(LocalDate.parse(startDate), LocalDate.parse(endDate), roadMap);
    }

    public List<TripHistory> getTripsHistoryByRoadMap(String roadMap) {
        return tripHistory.findByRoadMap(roadMap);
    }

    public List<TripHistory> getTripsHistoryByDateRange(String startDate, String endDate) {
        return tripHistory.findTripsByDateRange(LocalDate.parse(startDate), LocalDate.parse(endDate)); // Репозиторий, который фильтрует рейсы по диапазону дат
    }

    public List<String> getAllRoutes() {
        return tripRepository.findAllDistinctRoadMaps();
    }

}
