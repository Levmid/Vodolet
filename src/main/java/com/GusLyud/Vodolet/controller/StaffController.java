package com.GusLyud.Vodolet.controller;

import com.GusLyud.Vodolet.models.Boat;
import com.GusLyud.Vodolet.models.Staff;
import com.GusLyud.Vodolet.services.BoatService;
import com.GusLyud.Vodolet.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffService staffService;
    private final BoatService boatService;
    @Autowired
    public StaffController(StaffService staffService,BoatService boatService) {
        this.staffService = staffService;
        this.boatService = boatService;
    }

    @GetMapping("/find")
    public String findStaffById(@RequestParam(name = "id", required = false) Long id, Model model) {
        List<Boat> boats = boatService.getBoatInfo();
        model.addAttribute("boats", boats);
        if (id != null) {
            Staff staff = staffService.findById(id);
            model.addAttribute("staff", staff);
        } else {
            model.addAttribute("staff", null);
        }
        return "staff";
    }
    @PostMapping("/create")
    public String createStaff(@RequestParam String name,
                              @RequestParam String surname,
                              @RequestParam String post,
                              @RequestParam String age,
                              @RequestParam String birthday,
                              @RequestParam Long boat, Model model) {
        Staff newStaff = new Staff(name, surname,Integer.parseInt(age),post, LocalDate.parse(birthday), boatService.findById(boat));
        staffService.save(newStaff);

        model.addAttribute("staff", newStaff);
        return "staff";
    }


}
