package com.GusLyud.Vodolet.services;

import com.GusLyud.Vodolet.repo.PassengersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengersService {
    private final PassengersRepository passengersRepository;

    @Autowired
    public PassengersService(PassengersRepository passengersRepository) {
        this.passengersRepository = passengersRepository;
    }
}
