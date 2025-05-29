package com.edu.uceva.libproceso;

import libproceso.JavaProceso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/prioridades-service")
public class PrioridadesRestController {

    private final JavaProceso prioridades;

    public PrioridadesRestController() {
        this.prioridades = new JavaProceso();
    }

    // GET: recibir parámetros de 5 procesos vía query string
    @GetMapping("/prioridades")
    public String prioridad(
            @RequestParam List<Integer> id,
            @RequestParam List<Integer> llegada,
            @RequestParam List<Integer> rafaga,
            @RequestParam List<Integer> prioridad
    ) {
        if (id.size() != 5 || llegada.size() != 5 || rafaga.size() != 5 || prioridad.size() != 5) {
            return "Debe enviar exactamente 5 procesos con todos los campos.";
        }

        StringBuilder json = new StringBuilder("{\"procesos\":[");
        for (int i = 0; i < 5; i++) {
            json.append(String.format(
                    "{\"id\":%d,\"llegada\":%d,\"rafaga\":%d,\"prioridad\":%d}",
                    id.get(i),
                    llegada.get(i),
                    rafaga.get(i),
                    prioridad.get(i)
            ));
            if (i < 4) json.append(",");
        }
        json.append("]}");
        System.out.println("Procesos recibidos por GET: " + json);
        return prioridades.algoritmo_Prioridades(json.toString());
    }
}

