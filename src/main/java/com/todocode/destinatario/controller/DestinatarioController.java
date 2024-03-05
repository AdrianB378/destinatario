package com.todocode.destinatario.controller;

import com.todocode.destinatario.destinatarioDTO.destinatarioDTO;
import com.todocode.destinatario.model.Destinatario;
import com.todocode.destinatario.service.IDestinatarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/destinatarios")
public class DestinatarioController {
    
    @Autowired
    private IDestinatarioService destinaServ;
    
    // 1- Crear un destinatario
    @PostMapping ("/crear")
    public String crearDestinatario (@RequestBody destinatarioDTO destinatario) {
        destinaServ.saveDestinatario(destinatario.getDni() ,destinatario.getNombre() ,destinatario.getApellido() ,destinatario.getDireccion() , destinatario.getTelefono(), destinatario.getIdEnvio());
        
        return "El envio para el destinatario fue creado correctamente";
    }
    
    // 2- Traer destinatarios
    @GetMapping ("/traer")
    public List<Destinatario> traerDestinatarios() {
        return destinaServ.getDestinatarios();
        
    }
    
     //3- obtener un destinatario en particular
    @GetMapping ("/traer/{id}") // id es parametro, idDestinatario la id de Destinatario
    public Destinatario findDestinatario(@PathVariable Long id) {
        return destinaServ.findDestinatario(id);
                                    
    
    
    }   
    
    
    // 4- Editar destinatario
    @PutMapping("/editar/{id_original}")
    public Destinatario editDestinatario (@PathVariable Long id_original, 
            @RequestBody Destinatario destinatarioEditar ) {
        
        destinaServ.editDestinatario(id_original, destinatarioEditar);
        Destinatario destinatarioEditado = destinaServ.findDestinatario(id_original);
        
        return destinatarioEditado;
    } 
    
    
    // 5- Eliminar un destinatario
    @DeleteMapping("/borrar/{id}")
    public String deleteDestinatario(@PathVariable Long id) {
        destinaServ.deleteDestinatario(id);
        
        return "El destinatario fue eliminado correctamente ";
        
    }
    
   
   
    
}
