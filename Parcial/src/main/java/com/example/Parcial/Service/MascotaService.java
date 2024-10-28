package com.example.Parcial.Service;

import com.example.Parcial.InterfaceService.IMascotaService;
import com.example.Parcial.Model.Mascota;
import com.example.Parcial.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private MascotaRepository repositorio;

    @Override
    public List<Mascota> listar() {
        return repositorio.findAll();
    }

    @Override
    public void guardar(Mascota mascota) {
        repositorio.save(mascota);
    }

    @Override
    public Optional<Mascota> editar(int id) {
        return repositorio.findById(id);
    }

    @Override
    public void eliminar(int id) {
        repositorio.deleteById(id);
    }

    @Override
    public List<Mascota> obtenerTodasLasMascotas() {
        return repositorio.findAll();
    }
}
