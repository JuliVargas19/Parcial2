package com.example.Parcial.Controller;

import com.example.Parcial.InterfaceService.IVeterinarioService;
import com.example.Parcial.Model.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class VeterinarioController {

    @Autowired
    private IVeterinarioService service;

    @GetMapping("/listarVeterinarios")
    public String listarVeterinarios(Model model) {
        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "LISTA DE VETERINARIOS");
        model.addAttribute("datos", service.listarVeterinario());
        return "indexVeterinario";
    }

    @GetMapping("/nuevoVeterinario")
    public String formAgregarVeterinarios(Model model) {
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "USUARIO NUEVO");
        model.addAttribute("veterinario", new Veterinario());
        return "nuevoVeterinario";
    }

    @PostMapping("/guardarVeterinario")
    public String guardarVeterinarios(@ModelAttribute Veterinario veterinario) {
        service.guardarVeterinario(veterinario);
        return "redirect:/listarVeterinarios";
    }

    @GetMapping("/editarVeterinario/{id}")
    public String editarVeterinario(@PathVariable("id") int id, Model model) {
        model.addAttribute("veterinario", service.editarVeterinario(id));
        model.addAttribute("titulo", "Editar Veterinario");
        model.addAttribute("cuerpo", "Editar información del veterinario");
        return "nuevoVeterinario";
    }

    @GetMapping("/eliminarVeterinario/{id}")
    public String eliminarVeterinarios(@PathVariable("id") int id) {
        service.eliminarVeterinario(id);
        return "redirect:/listarVeterinarios";
    }
}
