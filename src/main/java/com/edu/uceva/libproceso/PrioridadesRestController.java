package com.edu.uceva.libproceso;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import libproceso.JavaProceso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prioridades-service")
public class PrioridadesRestController {
    private final JavaProceso prioridades;
    public PrioridadesRestController() {
        this.prioridades = new JavaProceso();
    }
    @GetMapping("/prioridades")
    public String calcularPrioridades(@RequestBody List<ProcesoDTO> procesos) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            String json = mapper.writeValueAsString(procesos);
            System.out.println("Enviando JSON a la biblioteca nativa: " + json);
            return prioridades.algoritmo_Prioridades(json);
        }catch (JsonProcessingException e){
            return "{\"error\": \"Error al procesar el JSON: " + e.getMessage() + "\"}";
        }
    }
}
