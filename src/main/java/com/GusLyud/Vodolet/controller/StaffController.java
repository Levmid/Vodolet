package com.GusLyud.Vodolet.controller;

import com.GusLyud.Vodolet.models.Staff;
import com.GusLyud.Vodolet.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffService staffService;

    @Autowired
    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/find")
    public String findStaffById(@RequestParam(name = "id", required = false) Long id, Model model) {
        if (id != null) {
            Staff staff = staffService.findById(id);
            model.addAttribute("staff", staff);
        } else {
            model.addAttribute("staff", null);
        }
        return "staff";
    }
}
