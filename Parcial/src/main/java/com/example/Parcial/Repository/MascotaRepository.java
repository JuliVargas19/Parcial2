package com.example.Parcial.Repository;

import com.example.Parcial.Model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MascotaRepository extends JpaRepository<Mascota, Integer> {
}
