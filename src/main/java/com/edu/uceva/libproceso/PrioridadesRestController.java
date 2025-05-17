package com.edu.uceva.libproceso;

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

    // GET: recibir parámetros de 5 procesos vía query string
    @GetMapping("/prioridades")
    public String prioridadPorGet(
            @RequestParam List<Integer> id_proceso,
            @RequestParam List<Integer> tiempo_llegada,
            @RequestParam List<Integer> tiempo_rafaga,
            @RequestParam List<Integer> prioridad
    ) {
        if (id_proceso.size() != 5 || tiempo_llegada.size() != 5 || tiempo_rafaga.size() != 5 || prioridad.size() != 5) {
            return "Debe enviar exactamente 5 procesos con todos los campos.";
        }

        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < 5; i++) {
            json.append(String.format(
                    "{\"id_proceso\":%d,\"tiempo_llegada\":%d,\"tiempo_rafaga\":%d,\"prioridad\":%d}",
                    id_proceso.get(i),
                    tiempo_llegada.get(i),
                    tiempo_rafaga.get(i),
                    prioridad.get(i)
            ));
            if (i < 4) json.append(",");
        }
        json.append("]");
        System.out.println("Procesos recibidos por GET: " + json);
        return prioridades.algoritmo_Prioridades(json.toString());
    }

    // Método auxiliar para construir JSON desde lista (POST)
    private String construirJsonDesdeLista(List<Map<String, Integer>> procesos) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < procesos.size(); i++) {
            Map<String, Integer> proceso = procesos.get(i);
            json.append(String.format(
                    "{\"id_proceso\":%d,\"tiempo_llegada\":%d,\"tiempo_rafaga\":%d,\"prioridad\":%d}",
                    proceso.get("id_proceso"),
                    proceso.get("tiempo_llegada"),
                    proceso.get("tiempo_rafaga"),
                    proceso.get("prioridad")
            ));
            if (i < procesos.size() - 1) {
                json.append(",");
            }
        }
        json.append("]");
        return json.toString();
    }
}

