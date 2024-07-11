//package br.com.squad04.consultoria.service;
//
//import br.com.squad04.consultoria.model.Consultas;
//
//import java.util.List;
//import java.util.Optional;

//public interface ConsultasService {
//    Consultas saveConsulta(Consultas consulta);
//    List<Consultas> getAllConsultas();
//    Optional<Consultas> getConsultaById(Long id);
//    void deleteConsulta(Long id);
//}

package br.com.squad04.consultoria.service;

import br.com.squad04.consultoria.model.Clientes;

import java.util.List;
import java.util.Optional;

public interface IClientesService {
    Clientes saveCliente(Clientes cliente);
    List<Clientes> getAllClientes();
    Optional<Clientes> getClienteById(int id);
    void deleteCliente(int id);
}