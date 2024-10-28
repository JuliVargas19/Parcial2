package com.example.Parcial.Model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "Consultas")
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha_consulta;

    private String motivo;
    private String diagnostico;

    @ManyToOne
    @JoinColumn(name = "Id_Mascota")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;
}
