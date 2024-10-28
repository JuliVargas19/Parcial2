package com.example.Parcial.InterfaceService;

import com.example.Parcial.Model.Propietario;

import java.util.List;
import java.util.Optional;

public interface IPropietarioService {

    public List<Propietario> listarpropietarios();

    public void guardarPropietario(Propietario propietario);

    public Optional<Propietario> editarPropietario(int id);

    public void elimarPropietario (int id);

    List<Propietario> obtenarTodosLosPropietarios();
}
