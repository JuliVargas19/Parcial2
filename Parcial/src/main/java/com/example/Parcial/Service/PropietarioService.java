package com.example.Parcial.Service;

import com.example.Parcial.InterfaceService.IPropietarioService;
import com.example.Parcial.Model.Propietario;
import com.example.Parcial.Repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropietarioService implements IPropietarioService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Override
    public List<Propietario> listarpropietarios() {
        return propietarioRepository.findAll();
    }

    @Override
    public void guardarPropietario(Propietario propietario) {
        propietarioRepository.save(propietario);
    }

    @Override
    public Optional<Propietario> editarPropietario(int id) {
        return propietarioRepository.findById(id);
    }

    @Override
    public void elimarPropietario(int id) {
        propietarioRepository.deleteById(id);
    }

    @Override
    public List<Propietario> obtenarTodosLosPropietarios() {
        return propietarioRepository.findAll();
    }
}
