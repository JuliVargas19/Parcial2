package com.example.Parcial.Service;

import com.example.Parcial.InterfaceService.IVeterinarioService;
import com.example.Parcial.Model.Veterinario;
import com.example.Parcial.Repository.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarioService implements IVeterinarioService {

    @Autowired
    private VeterinarioRepository repository;

    @Override
    public List<Veterinario> listarVeterinario() {
        return repository.findAll();
    }

    @Override
    public void guardarVeterinario(Veterinario veterinario) {
        repository.save(veterinario);
    }

    @Override
    public Optional<Veterinario> editarVeterinario(int id) {
        return repository.findById(id);
    }

    @Override
    public void eliminarVeterinario(int id) {
        repository.deleteById(id); // Elimina el veterinario por ID.
    }


    @Override
    public List<Veterinario> obtenerTodosLosVeterinarios() {
        return repository.findAll();
    }
}
