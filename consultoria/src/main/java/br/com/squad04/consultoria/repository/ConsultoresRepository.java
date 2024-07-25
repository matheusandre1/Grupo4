package br.com.squad04.consultoria.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.squad04.consultoria.model.Consultores;

@Repository
public interface ConsultoresRepository extends JpaRepository<Consultores, Long> {
    List<Consultores> findAll(Sort sort);
} 
