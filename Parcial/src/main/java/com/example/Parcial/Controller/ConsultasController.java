package com.example.Parcial.Controller;

import com.example.Parcial.InterfaceService.IConsultasService;
import com.example.Parcial.Model.Consultas;
import com.example.Parcial.Service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.Parcial.Service.MascotaService;

@Controller
@RequestMapping
public class ConsultasController {

    @Autowired
    private VeterinarioService veterinarioService;

    @Autowired
    private MascotaService mascotaService;

    @Autowired
    private IConsultasService consultasService;

    @GetMapping("/listarConsultas")
    public String listarConsultas(Model model) {
        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "LISTA DE CONSULTAS");
        model.addAttribute("mascotas", mascotaService.obtenerTodasLasMascotas());
        model.addAttribute("veterinarios", veterinarioService.obtenerTodosLosVeterinarios());
        model.addAttribute("consultas", consultasService.listarConsultas());
        return "indexConsultas";
    }

    @GetMapping("/nuevaConsulta")
    public String mostrarFormularioNuevaConsulta(Model model) {
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "Ingrese los datos de la consulta");
        model.addAttribute("mascotas", mascotaService.obtenerTodasLasMascotas());
        model.addAttribute("veterinarios", veterinarioService.obtenerTodosLosVeterinarios());
        model.addAttribute("consulta", new Consultas());
        return "nuevaConsulta";
    }

    @PostMapping("/guardarConsultas")
    public String guardarConsultas(@ModelAttribute Consultas consulta) {
        consultasService.guardarConsultas(consulta);
        return "redirect:/listarConsultas";
    }

    @GetMapping("/editarConsulta/{id}")
    public String editarConsultas(@PathVariable("id") int id, Model model) {
        model.addAttribute("mascotas", mascotaService.obtenerTodasLasMascotas());
        model.addAttribute("veterinarios", veterinarioService.obtenerTodosLosVeterinarios());
        model.addAttribute("consulta", consultasService.editarConsultas(id));
        consultasService.editarConsultas(id).ifPresent(consultas -> model.addAttribute("consultas", consultas));
        return "nuevaConsulta";
    }

    @GetMapping("/eliminarConsulta/{id}")
    public String eliminarConsultas(@PathVariable("id") int id) {
        consultasService.eliminarConsultas(id);
        return "redirect:/listarConsultas";
    }
}
