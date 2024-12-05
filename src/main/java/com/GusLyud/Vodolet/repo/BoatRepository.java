package com.GusLyud.Vodolet.repo;

import com.GusLyud.Vodolet.models.Boat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoatRepository extends JpaRepository<Boat,Long> {
}
