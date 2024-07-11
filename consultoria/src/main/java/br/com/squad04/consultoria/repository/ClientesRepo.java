package br.com.squad04.consultoria.repository;

import br.com.squad04.consultoria.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepo extends JpaRepository<Clientes, Integer> {
}
