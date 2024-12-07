package com.GusLyud.Vodolet.repo;

import com.GusLyud.Vodolet.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {

    }
