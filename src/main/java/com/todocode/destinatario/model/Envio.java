package com.todocode.destinatario.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Envio {
    

    private Long idEnvio;
    private LocalDate fechaCreacion;
    private String estado;
    private String descripcion;
    

}
