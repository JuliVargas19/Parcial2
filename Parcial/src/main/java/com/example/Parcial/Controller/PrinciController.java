package com.example.Parcial.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrinciController {

    @GetMapping("/indexPrinci")
    public String showIndexPrincipal(){ return "indexPrinci";}
}
