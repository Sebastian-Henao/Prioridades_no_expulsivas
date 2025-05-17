package com.edu.uceva.libproceso;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import libproceso.JavaProceso;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/prioridades-service")
public class PrioridadesRestController {
    private final JavaProceso prioridades;
    public PrioridadesRestController() {
        this.prioridades = new JavaProceso();
    }
    @PostMapping("/prioridades")
    public String prioridad(@RequestBody List<Map<String, Integer>> procesos) {
        System.out.println("Procesos recibidos: " + procesos);
        String json = "[";
        for (int i = 0; i < procesos.size(); i++) {
            Map<String, Integer> proceso = procesos.get(i);
            json += String.format("{\"id_proceso\":%d,\"tiempo_llegada\":%d,\"tiempo_rafaga\":%d,\"prioridad\":%d}",
                    proceso.get("id_proceso"),
                    proceso.get("tiempo_llegada"),
                    proceso.get("tiempo_rafaga"),
                    proceso.get("prioridad"));
            if (i < procesos.size() - 1)
                json += ",";
        }
        json += "]";
        System.out.println("Enviando JSON a la biblioteca natica: " + json);
        return prioridades.algoritmo_Prioridades(json);
    }
}
