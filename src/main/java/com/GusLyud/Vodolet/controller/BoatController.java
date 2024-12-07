package com.GusLyud.Vodolet.controller;
import com.GusLyud.Vodolet.services.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/api/boat")
public class BoatController {
    private final BoatService boatService;

    @Autowired
    public BoatController(BoatService boatService) {
        this.boatService = boatService;
    }

    @GetMapping("/info")
    public String getBoatInfo(Model model){
        model.addAttribute("boats", boatService.getBoatInfo());
        return "boats";
    }
}
