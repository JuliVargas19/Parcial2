package com.example.Parcial.InterfaceService;

import com.example.Parcial.Model.Mascota;
import com.example.Parcial.Model.Propietario;

import java.util.List;
import java.util.Optional;

public interface IMascotaService {

    public List<Mascota> listar();

    public void guardar(Mascota Mascota);

    public Optional<Mascota> editar(int id);

    public void eliminar (int id);

    List<Mascota> obtenerTodasLasMascotas();
}
