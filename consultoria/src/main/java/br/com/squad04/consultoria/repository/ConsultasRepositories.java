package br.com.squad04.consultoria.repository;

import br.com.squad04.consultoria.model.Consultas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ConsultasRepositories extends JpaRepository<Consultas, Long> {
}

