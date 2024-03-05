package com.todocode.destinatario.service;

import com.todocode.destinatario.model.Destinatario;
import java.util.List;

public interface IDestinatarioService {
    
    // Metodo para crear un nuevo Destinatario
    public String saveDestinatario(String dni, String nombre, String apellido, String direccion, String telefono, Long idEnvio);
    
    // Metodo para obtener todos los Destinatarios
    public List<Destinatario> getDestinatarios();
    
    // Metodo para obtener un destinatario por su Id
    public Destinatario findDestinatario(Long id);
    
    // Metodo para editar un destinatario existente
    public String editDestinatario(Long id, Destinatario destinatario);
    
    //Metodo para eliminar un destinatario por su id
    public String deleteDestinatario(Long id);
    
    
}
