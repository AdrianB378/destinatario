package com.todocode.destinatario.repository;

import com.todocode.destinatario.model.Destinatario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDestinatarioRepository extends JpaRepository<Destinatario, Long> {
    
}
