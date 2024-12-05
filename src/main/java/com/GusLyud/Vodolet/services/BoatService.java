package com.GusLyud.Vodolet.services;

import com.GusLyud.Vodolet.repo.BoatRepository;
import com.GusLyud.Vodolet.repo.PassengersRepository;
import com.GusLyud.Vodolet.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
