package com.GusLyud.Vodolet.services;

import com.GusLyud.Vodolet.models.Staff;
import com.GusLyud.Vodolet.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffService(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    public Staff findById(Long id) {
        return staffRepository.findById(id).orElse(null);
    }
}
