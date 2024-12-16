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
                              @RequestParam(required = false) String endDate,
                              @RequestParam(required = false) String roadMap, // Новый параметр для маршрута
                              Model model) {
        List<Trip> trips;
        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
            if (roadMap != null && !roadMap.isEmpty()) {
                trips = tripService.getTripsByDateRangeAndRoadMap(startDate, endDate, roadMap);
            } else {
                trips = tripService.getTripsByDateRange(startDate, endDate);
            }
        } else {
            if (roadMap != null && !roadMap.isEmpty()) {
                trips = tripService.getTripsByRoadMap(roadMap);
            } else {
                trips = tripService.getAllTrips();
            }
        }

        model.addAttribute("trips", trips);
        model.addAttribute("routes", tripService.getAllRoutes()); // Добавляем список маршрутов для выпадающего списка
        return "trips";
    }



    @GetMapping("/get-history-info")
    public String getTripHistoryInfo(@RequestParam(required = false) String startDate,
                                     @RequestParam(required = false) String endDate,
                                     @RequestParam(required = false) String roadMap,
                                     Model model){
        List<TripHistory> trips;
        if (startDate != null && !startDate.isEmpty() && endDate != null && !endDate.isEmpty()) {
            if (roadMap != null && !roadMap.isEmpty()) {
                trips = tripService.getTripsHistoryByDateRangeAndRoadMap(startDate, endDate, roadMap);
            } else {
                trips = tripService.getTripsHistoryByDateRange(startDate, endDate);
            }
        } else {
            if (roadMap != null && !roadMap.isEmpty()) {
                trips = tripService.getTripsHistoryByRoadMap(roadMap);
            } else {
                trips = tripService.getAllHistoryTrips();
            }
        }

        model.addAttribute("tripshistory",trips);
        model.addAttribute("routes", tripService.getAllRoutes());
        double totalProfit = trips.stream().mapToDouble(TripHistory::getProfit).sum();
        model.addAttribute("totalProfit", totalProfit);
        return "tripshistory";
    }

}
