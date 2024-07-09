package br.com.squad04.consultoria.service;

import br.com.squad04.consultoria.model.Clientes;
import org.springframework.http.ResponseEntity;

public interface IClientesService {
    ResponseEntity<?> cadastrarCliente(Clientes cliente);

    Object recuperarClientes();

    Clientes buscarCliente(int idCliente);

    ResponseEntity<?> atualizarCliente(Clientes cliente);

    ResponseEntity<?> deletarCliente(int idCliente);
}
