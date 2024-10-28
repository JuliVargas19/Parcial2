package com.example.Parcial.Repository;

import com.example.Parcial.Model.Consultas;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas, Integer> {
}
