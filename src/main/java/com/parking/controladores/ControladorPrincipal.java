package com.parking.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author franc
 */
@Controller
public class ControladorPrincipal {
    
    @GetMapping("/")
    public String cargarPaginaPrincipal() {
        return "index";
    }
}
