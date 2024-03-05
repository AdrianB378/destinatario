
package com.todocode.destinatario.repository;

import com.todocode.destinatario.model.Envio;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "enviosapi", url = "http://localhost:9005/envios")
public interface IEnvioAPIClient {
 
    @GetMapping ("/traerid/{id}")
    public Envio getEnvio (@PathVariable ("id") Long id);
            
    
}
