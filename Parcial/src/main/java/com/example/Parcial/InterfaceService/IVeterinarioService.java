package com.example.Parcial.InterfaceService;

import com.example.Parcial.Model.Veterinario;

import java.util.List;
import java.util.Optional;

public interface IVeterinarioService {

    List<Veterinario> listarVeterinario();

    void guardarVeterinario(Veterinario veterinario);

    Optional<Veterinario> editarVeterinario(int id);

    void eliminarVeterinario(int id);


    List<Veterinario> obtenerTodosLosVeterinarios();

}
