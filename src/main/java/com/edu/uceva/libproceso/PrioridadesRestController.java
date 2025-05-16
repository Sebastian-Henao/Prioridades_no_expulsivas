package com.edu.uceva.libproceso;

import libproceso.JavaProceso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prioridades-service")
public class PrioridadesRestController {
    private JavaProceso prioridades;
    public PrioridadesRestController() {
        this.prioridades = new JavaProceso();
    }
    @GetMapping("/prioridades/{id}/{llegada}/{rafaga}/{prioridad}")
    public String prioridad(@PathVariable int id_proceso, @PathVariable int tiempo_llegada, @PathVariable int tiempo_rafaga, @PathVariable int prioridad) {
        return prioridades.algoritmo_Prioridades(id_proceso, tiempo_llegada, tiempo_rafaga, prioridad);
    }
}
