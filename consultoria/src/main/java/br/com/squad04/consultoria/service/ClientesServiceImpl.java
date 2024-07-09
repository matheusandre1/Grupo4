package br.com.squad04.consultoria.service;

import br.com.squad04.consultoria.model.Clientes;
import br.com.squad04.consultoria.repository.ClientesRepo;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;



@Service
public class ClientesServiceImpl implements IClientesService {

    @Autowired
    public ClientesRepo clientesRepo;

    private static final Logger logger = LoggerFactory.getLogger(ClientesServiceImpl.class);

    @Override
    public ResponseEntity<?> cadastrarCliente(Clientes cliente) {
        try{
            if (cliente.getNomeEmpresa() == null || cliente.getNomeEmpresa().isEmpty()) {
                logger.error("Nome da empresa é obrigatório");
                return ResponseEntity.badRequest().body("Nome da empresa é obrigatório.");
            }

            if (cliente.getNomeResponsavel() == null || cliente.getNomeResponsavel().isEmpty()) {
                logger.error("Nome do responsavel é obrigatório");
                return ResponseEntity.badRequest().body("Nome do responsavel é obrigatório.");
            }

            if (cliente.getCnpj() == null || cliente.getCnpj().isEmpty()) {
                logger.error("O cnpj é obrigatório");
                return ResponseEntity.badRequest().body("O cnpj é obrigatório.");
            }

            if (cliente.getDataCadastro() == null) {
                logger.error("A data de cadastro é obrigatória");
                return ResponseEntity.badRequest().body("A data de cadastro é obrigatória.");
            }

            if (cliente.getTelefone() == null|| cliente.getTelefone().isEmpty()) {
                logger.error("O telefone é obrigatório");
                return ResponseEntity.badRequest().body("O telefone é obrigatório.");
            }

            if (cliente.getEmail() == null|| cliente.getEmail().isEmpty()) {
                logger.error("O email é obrigatório");
                return ResponseEntity.badRequest().body("O email é obrigatório");
            }

            if (cliente.getSenha() == null|| cliente.getSenha().isEmpty()) {
                logger.error("A senha é obrigatória");
                return ResponseEntity.badRequest().body("A senha é obrigatória");
            }

            if (cliente.getTipoDeUsuario() == null|| cliente.getTipoDeUsuario().isEmpty()) {
                logger.error("O tipo de usuário é obrigatório");
                return ResponseEntity.badRequest().body("O tipo de usuário é obrigatório");
            }

//            if (cliente.getIdConsultor() == null) {
//                logger.error("O tipo de consultor é obrigatório");
//                return ResponseEntity.badRequest().body("O tipo de consultor é obrigatório");
//            }

            clientesRepo.save(cliente);
            logger.info("Cliente cadastrado com sucesso: {}", cliente);

            return ResponseEntity.ok().build();
        }catch (Exception e) {
            logger.error("Ocorreu um erro ao cadastrar o cliente.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o cliente.");
        }

    }

    @Override
    public Object recuperarClientes() {
        try{
            return clientesRepo.findAll();
        }catch (Exception e){
            return null;
        }
    }

    @Override
    public Clientes buscarCliente(int idCliente) {
        try {
            return clientesRepo.findById(idCliente).orElse(null);
        } catch (Exception e){
            return null;
        }
    }


    @Override
    public ResponseEntity<?> atualizarCliente(Clientes cliente) {
        try {
            Clientes clienteExistente = clientesRepo.findById(cliente.getIdCliente()).orElse(null);
            if (clienteExistente != null) {
                // Atualiza os dados do cliente existente com os novos dados
                clienteExistente.setNomeEmpresa(cliente.getNomeEmpresa());
                clienteExistente.setNomeResponsavel(cliente.getNomeResponsavel());
                clienteExistente.setCnpj(cliente.getCnpj());
                clienteExistente.setDataCadastro(cliente.getDataCadastro());
                clienteExistente.setTelefone(cliente.getTelefone());
                clienteExistente.setEmail(cliente.getEmail());
                clienteExistente.setSenha(cliente.getSenha());
                clienteExistente.setTipoDeUsuario(cliente.getTipoDeUsuario());
//                clienteExistente.setIdConsultor(cliente.getIdConsultor());

                // Salva o cliente atualizado no banco de dados
                clientesRepo.save(clienteExistente);

                logger.info("Aluno atualizado com sucesso: {}", clienteExistente);
                return ResponseEntity.ok("Cliente atualizado com sucesso.");
            } else {
                logger.error("Cliente não encontrado para atualização.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado para atualização.");
            }
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao atualizar o cliente.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao atualizar o cliente.");
        }
    }


    @Override
    public ResponseEntity<?> deletarCliente(int idCliente) {
        try {
            Clientes clienteExistente = clientesRepo.findById(idCliente).orElse(null);
            if (clienteExistente != null) {
                // Remove o cliente do banco de dados
                clientesRepo.delete(clienteExistente);

                logger.info("Cliente excluído com sucesso: {}", clienteExistente);
                return ResponseEntity.ok("Cliente excluído com sucesso.");
            } else {
                logger.error("Cliente não encontrado para exclusão.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado para exclusão.");
            }
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao excluir o cliente.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao excluir o cliente.");
        }
    }





}
