package br.com.squad04.consultoria.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.squad04.consultoria.model.Consultas;

@Repository
public interface ConsultasRepository extends JpaRepository<Consultas, Long> {
    List<Consultas> findAll(Sort sort);
} 
