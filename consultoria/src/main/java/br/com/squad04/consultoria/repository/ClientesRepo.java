package br.com.squad04.consultoria.repository;

import br.com.squad04.consultoria.model.Clientes;
import org.springframework.data.repository.CrudRepository;

public interface ClientesRepo extends CrudRepository<Clientes, Integer> {
}
