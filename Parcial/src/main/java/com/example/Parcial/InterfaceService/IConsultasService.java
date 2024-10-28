package com.example.Parcial.InterfaceService;

import com.example.Parcial.Model.Consultas;
import com.example.Parcial.Model.Propietario;

import java.util.List;
import java.util.Optional;


public interface IConsultasService {


    public List<Consultas> listarConsultas();

    public void guardarConsultas(Consultas consultas);

    public Optional<Consultas> editarConsultas(int id);

    public void eliminarConsultas (int id);


}
