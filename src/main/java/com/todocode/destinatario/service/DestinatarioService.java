package com.todocode.destinatario.service;

import com.todocode.destinatario.model.Destinatario;
import com.todocode.destinatario.model.Envio;
import com.todocode.destinatario.repository.IDestinatarioRepository;
import com.todocode.destinatario.repository.IEnvioAPIClient;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DestinatarioService implements IDestinatarioService {

    @Autowired
    private IDestinatarioRepository destinaRepo; 
    
    @Autowired
    private IEnvioAPIClient enviosapi;
    
    @Override
    public String saveDestinatario(String dni, String nombre, String apellido, String direccion, String telefono, Long idEnvio) {
           
        Envio env = enviosapi.getEnvio(idEnvio);
        
        if (env != null && env.getIdEnvio() != null) {
        Long identEnvio = env.getIdEnvio();
        
        Destinatario destinatario = new Destinatario();
        destinatario.setDni(dni);
        destinatario.setNombre(nombre);
        destinatario.setApellido(apellido);
        destinatario.setDireccion(direccion);
        destinatario.setTelefono(telefono);
        destinatario.setIdentEnvio(identEnvio);
        
        destinaRepo.save(destinatario);
        
        return "El destinatario se ha creado correctamente";
        
        } else {
        
         return "El destinatario no se ha creado";
    }   
    
    }    
        
    @Override
    public List<Destinatario> getDestinatarios() {
        return destinaRepo.findAll();
        
    }

    @Override
    public Destinatario findDestinatario(Long id) {
        return destinaRepo.findById(id).orElse(null);
        
        
    }

    @Override
    public String editDestinatario(Long id, Destinatario destinatario) {
        
        Destinatario desti = this.findDestinatario(id);
        
       
        
        desti.setDni(destinatario.getDni());
        desti.setNombre(destinatario.getNombre());
        desti.setApellido(destinatario.getApellido());
        desti.setDireccion(destinatario.getDireccion());
        desti.setTelefono(destinatario.getTelefono());
        desti.setIdentEnvio(destinatario.getIdentEnvio());
        
        destinaRepo.save(desti);
        
        return "El destinatario se ha editado correctamente";
       
    }

    @Override
    public String deleteDestinatario(Long id) {
        destinaRepo.deleteById(id);
        return "El destinatario fue eliminado correctamente";

    }

    
    
}
