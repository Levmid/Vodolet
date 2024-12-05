package com.GusLyud.Vodolet.repo;

import com.GusLyud.Vodolet.models.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers, Long> {
}
