package com.edu.uceva.libproceso;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcesoDTO {
    private int id_proceso;
    private int tiempo_llegada;
    private int tiempo_rafaga;
    private int prioridad;
}
