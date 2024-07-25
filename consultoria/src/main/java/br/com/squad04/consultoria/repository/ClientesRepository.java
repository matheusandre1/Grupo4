package br.com.squad04.consultoria.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.squad04.consultoria.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long> {
    List<Clientes> findAll(Sort sort);
}
