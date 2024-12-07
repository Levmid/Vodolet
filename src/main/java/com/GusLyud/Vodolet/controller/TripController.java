package com.GusLyud.Vodolet.controller;

import com.GusLyud.Vodolet.models.Trip;
import com.GusLyud.Vodolet.models.TripHistory;
import com.GusLyud.Vodolet.repo.TripHistoryRepository;
import com.GusLyud.Vodolet.services.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/api/trip")
public class TripController {
    private final TripService tripService;
    private final TripHistoryRepository tripHistoryRepository;

    public TripController(TripService tripService,TripHistoryRepository tripHistoryRepository) {
        this.tripService = tripService;
        this.tripHistoryRepository = tripHistoryRepository;
    }

    @GetMapping("/get-info")
    public String getTripInfo(@RequestParam(required = false) String startDate,
                              @RequestParam(required = false) String endDate, Model model){
        List<Trip> trips;
        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
            trips = tripService.getTripsByDateRange(startDate, endDate);
        } else {
            trips = tripService.getAllTrips();
        }
        model.addAttribute("trips", trips);
        return "trips";
    }

    @GetMapping("/get-history-info")
    public String getTripHistoryInfo(@RequestParam(required = false) String startDate,
                                     @RequestParam(required = false) String endDate, Model model){
        List<TripHistory> trips;
        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
            trips = tripService.getTripsHistoryByDateRange(startDate, endDate);
        } else {
            trips = tripService.getAllHistoryTrips();
        }
        model.addAttribute("tripshistory",trips);
        return "tripshistory";
    }

}
