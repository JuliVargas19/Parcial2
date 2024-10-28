package com.example.Parcial.Controller;

import com.example.Parcial.InterfaceService.IPropietarioService;
import com.example.Parcial.Model.Propietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class PropietarioController {

    @Autowired
    private IPropietarioService service;

    @GetMapping("/listarPropietarios")
    public String listarPropietarios(Model model) {
        model.addAttribute("titulo", "Spring DB");
        model.addAttribute("cuerpo", "LISTA DE PROPIETARIOS");
        model.addAttribute("datos", service.listarpropietarios());
        return "indexPropietario";
    }

    @GetMapping("/nuevoPropietario")
    public String formAgregarPropietario(Model model) {
        model.addAttribute("titulo", "Nuevo");
        model.addAttribute("cuerpo", "USUARIO NUEVO");
        model.addAttribute("propietario", new Propietario());
        return "nuevoPropietario";
    }

    @PostMapping("/guardarPropietario")
    public String guardarPropietario(@ModelAttribute Propietario propietario) {
        service.guardarPropietario(propietario);
        return "redirect:/listarPropietarios";
    }

    @GetMapping("/editarPropietario/{id}")
    public String editarPropietario(@PathVariable("id") int id, Model model) {
        service.editarPropietario(id).ifPresent(propietario -> model.addAttribute("propietario", propietario));
        return "nuevoPropietario";
    }

    @GetMapping("/eliminarPropietario/{id}")
    public String eliminarPropietario(@PathVariable("id") int id) {
        service.elimarPropietario(id);
        return "redirect:/listarPropietarios";
    }
}
