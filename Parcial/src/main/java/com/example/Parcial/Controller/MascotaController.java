package com.example.Parcial.Controller;

import com.example.Parcial.InterfaceService.IMascotaService;
import com.example.Parcial.Model.Mascota;
import com.example.Parcial.Repository.MascotaRepository;
import com.example.Parcial.Service.PropietarioService;
import com.example.Parcial.Service.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class MascotaController {

    private VeterinarioService veterinariosService;
    @Autowired
    private PropietarioService propietarioService;
    @Autowired
    private IMascotaService service;


    @GetMapping("/listar")
    public String listarMascota(Model model) {

        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "LISTA DE MASCOTAS");
        model.addAttribute("propietarios", propietarioService.obtenarTodosLosPropietarios());

        model.addAttribute("datos", service.listar());
        return "index";
    }

    @GetMapping("/nuevo")
    public String formAgregarMascota(Model model) {

        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "MASCOTA NUEVA");
        model.addAttribute("propietarios", propietarioService.obtenarTodosLosPropietarios());

        model.addAttribute("Mascota", new Mascota());
        return "nuevo";
    }

    @PostMapping("/guardar")
    public String guardarMascota(@ModelAttribute Mascota Mascota) {

        service.guardar(Mascota);

        return "redirect:/listar";
    }


    @GetMapping("/editar/{id}")
    public String editarMascota(@PathVariable("id") int id, Model model) {

        model.addAttribute("propietarios", propietarioService.obtenarTodosLosPropietarios());

        model.addAttribute("Mascota", service.editar(id));

        return "nuevo";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminarMascota(@PathVariable("id") int id) {

        service.eliminar(id);

        return "redirect:/listar";
    }
}

