package com.GusLyud.Vodolet.services;

import com.GusLyud.Vodolet.models.Boat;
import com.GusLyud.Vodolet.models.Staff;
import com.GusLyud.Vodolet.repo.BoatRepository;
import com.GusLyud.Vodolet.repo.PassengersRepository;
import com.GusLyud.Vodolet.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoatService {
    private final BoatRepository boatRepository;
    private final StaffRepository staffRepository;
    private final PassengersRepository passengersRepository;

    @Autowired
    public BoatService(BoatRepository boatRepository, StaffRepository staffRepository,
                       PassengersRepository passengersRepository) {
        this.boatRepository = boatRepository;
        this.staffRepository = staffRepository;
        this.passengersRepository = passengersRepository;
    }

    public List<Boat> getBoatInfo() {
        return boatRepository.findAll();
    }
    public Boat findById(Long id) {
        return boatRepository.findById(id).orElse(null);
    }
}
