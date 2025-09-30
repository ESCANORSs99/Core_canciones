package com.joaomoris.canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.joaomoris.canciones.modelos.Cancion;
import com.joaomoris.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;





@Controller
public class ControladorCanciones {
    
    @Autowired
    private final ServicioCanciones servicioCanciones;  

    public ControladorCanciones(ServicioCanciones servicioCanciones) {
        this.servicioCanciones = servicioCanciones;
    }

    @GetMapping("/canciones")
    public String desplegarCanciones(Model modelo) {
        List<Cancion>  listaCanciones = servicioCanciones.obtenerTodasLasCanciones();
        modelo.addAttribute("listaCanciones", listaCanciones);
        return "canciones";

    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(@PathVariable Long idCancion, Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "detalleCancion";
    }
    
    @GetMapping("/canciones/formulario/agregar")
    public String desplegarFormularioCancion(@ModelAttribute("nuevaCancion") Cancion nuevaCancion) {
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String agregarCancion(@Valid @ModelAttribute("nuevaCancion")Cancion nuevaCancion,
                                    BindingResult validaciones) {
        if (validaciones.hasErrors()) {
        return "formularioCancion";
    }
        this.servicioCanciones.agregar(nuevaCancion);

        return "redirect:/canciones";
    }


    
    
}
