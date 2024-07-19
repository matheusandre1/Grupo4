package br.com.squad04.consultoria.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad04.consultoria.model.Clientes;
import br.com.squad04.consultoria.repository.ClientesRepository;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

    public Optional<Clientes> getClienteById(Long idCliente) {
        return clientesRepository.findById(idCliente);
    }

    public Clientes saveCliente(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    public void deleteCliente(Long idCliente) {
        clientesRepository.deleteById(idCliente);
    }
}

package br.com.squad04.consultoria.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.squad04.consultoria.model.Clientes;
import br.com.squad04.consultoria.repository.ClientesRepository;

@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> getAllClientes() {
        return clientesRepository.findAll();
    }

    public Optional<Clientes> getClienteById(Long idCliente) {
        return clientesRepository.findById(idCliente);
    }

    public Clientes saveCliente(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    public void deleteCliente(Long idCliente) {
        clientesRepository.deleteById(idCliente);
    }
}
