package br.com.squad04.consultoria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.squad04.consultoria.model.Consultor;

@Repository
public interface ConsultorRepository extends JpaRepository<Consultor, Long> {
   
} 
