package com.GusLyud.Vodolet.services;

import com.GusLyud.Vodolet.models.Trip;
import com.GusLyud.Vodolet.models.TripHistory;
import com.GusLyud.Vodolet.repo.BoatRepository;
import com.GusLyud.Vodolet.repo.TripHistoryRepository;
import com.GusLyud.Vodolet.repo.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
