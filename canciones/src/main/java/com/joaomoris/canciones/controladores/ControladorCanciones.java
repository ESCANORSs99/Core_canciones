package com.joaomoris.canciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.joaomoris.canciones.modelos.Cancion;
import com.joaomoris.canciones.servicios.ServicioCanciones;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;





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

    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable Long idCancion,
                                            Model modelo) {
        Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
        modelo.addAttribute("cancion", cancion);
        return "editarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String agregarCancion(@Valid @ModelAttribute("nuevaCancion")Cancion nuevaCancion,
                                    BindingResult validaciones) {
        if (validaciones.hasErrors()) {
        return "agregarCancion";
    }
        this.servicioCanciones.agregar(nuevaCancion);

        return "redirect:/canciones";
    }

    @PutMapping("/canciones/procesa/editar/{idCancion}")
    public String actualizarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
                                    BindingResult validaciones,
                                    @PathVariable Long idCancion) {
        if (validaciones.hasErrors()) {
            return "editarCancion";
        }
        cancion.setId(idCancion);
        this.servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones/detalle/" + idCancion;
    }
    

    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable Long idCancion){
        this.servicioCanciones.eliminaCancion(idCancion);
        return "redirect:/canciones";
    }
    
    
}
