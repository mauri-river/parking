package com.parking.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author franc
 */
@Controller
public class ControladorPrincipal {

    @GetMapping("/")
    public String cargarIndex() {
        return "index";
    }
    @GetMapping("/Categorias")
    public String cargarListaCategorias(Model model, @RequestParam(value="Criterio",required=false)String Criterio) {
        if (Criterio== null) {
            model.addAttribute("Categorias",Servicio.consultarCategorias());
        }
        else {
           model.addAttribute("Categorias",Servicio.consultarCategorias(Criterio));
           model.addAttribute("Criterio",Criterio);
        }
        return "ListaCategorias";
    }
    @PostMapping("/Categorias")
    public String guardarCategorias(@ModelAttribute("Categoria")Categoria c){
        Servicio.crearNuevaCategoria(c);
        return "redirect:/Categorias";
    }
   @GetMapping("/Categorias/form") 
   public String cargarFormNuevaCategorias(Model modelo){
       Categoria c =new Categoria();
       modelo.addAttribute("Categoria",c);
       return "formCategorias";
   }
   @GetMapping("/Categorias/form/{id}") 
   public String cargarFormCategoriaExistente(Model modelo, @PathVariable int id){
       Categoria c =Servicio.consultarCategorias(id);
       modelo.addAttribute("Categoria",c);
       return "formCategorias";     
   }

}