package br.com.squad04.consultoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.squad04.consultoria.model.Consultas;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas, Long> {
 
} 
