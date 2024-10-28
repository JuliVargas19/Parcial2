package com.example.Parcial.Service;

import com.example.Parcial.InterfaceService.IConsultasService;
import com.example.Parcial.Model.Consultas;
import com.example.Parcial.Repository.ConsultasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsultasService implements IConsultasService {

    @Autowired
    private ConsultasRepository repositorio;


    public List<Consultas> listarConsultas() {
        return repositorio.findAll();
    }


    @Override
    public void guardarConsultas(Consultas consultas)
        { repositorio.save(consultas);
    }


    @Override
    public Optional<Consultas> editarConsultas(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminarConsultas(int id) {

        repositorio.deleteById(id);

    }

}
