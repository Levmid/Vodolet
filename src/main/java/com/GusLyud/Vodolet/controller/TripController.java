package com.GusLyud.Vodolet.controller;

import com.GusLyud.Vodolet.repo.TripHistoryRepository;
import com.GusLyud.Vodolet.services.TripService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String getTripInfo(Model model){
        System.out.println("Method getTripInfo called");
        model.addAttribute("trips",tripService.getAllTrips());
        return "trips";
    }

}
