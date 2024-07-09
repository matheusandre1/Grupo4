package br.com.squad04.consultoria.controller;

import br.com.squad04.consultoria.model.Clientes;
import br.com.squad04.consultoria.service.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class ClientesController {

    @Autowired
    private IClientesService iClientesService;

    @PostMapping("/clientes")
    public ResponseEntity<String> cadastrarCliente(@RequestBody Clientes cliente) {
        try {
            ResponseEntity<?> resposta = iClientesService.cadastrarCliente(cliente);
            // Verifica se o corpo da resposta não é nulo antes de chamá-lo
            String responseBody = resposta.getBody() != null ? resposta.getBody().toString() : "";
            return ResponseEntity.status(resposta.getStatusCode()).body(responseBody);
        } catch (Exception e) {
            // Log da exceção para fins de depuração
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o cliente.");
        }
    }

    @GetMapping("/clientes")
    public ResponseEntity<ArrayList<Clientes>> listarClientes() {
        ArrayList<Clientes> clientes= (ArrayList<Clientes>) iClientesService.recuperarClientes();
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("cliente/{idCliente}")
    public ResponseEntity<Clientes> buscarCliente(@PathVariable("idCliente") int idCliente) {
        Clientes cliente = iClientesService.buscarCliente(idCliente);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{idCliente}")
    public ResponseEntity<String> atualizarCliente(@PathVariable("idCliente") int idCliente, @RequestBody Clientes cliente) {
        try {
            ResponseEntity<?> resposta = iClientesService.atualizarCliente(cliente);
            String responseBody = resposta.getBody() != null ? resposta.getBody().toString() : "";
            return ResponseEntity.status(resposta.getStatusCode()).body(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao atualizar o cliente.");
        }
    }

    @DeleteMapping("/{idCliente}")
    public ResponseEntity<String> deletarCliente(@PathVariable("idCliente") int idCliente) {
        try {
            ResponseEntity<?> resposta = iClientesService.deletarCliente(idCliente);
            String responseBody = resposta.getBody() != null ? resposta.getBody().toString() : "";
            return ResponseEntity.status(resposta.getStatusCode()).body(responseBody);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao excluir o cliente.");
        }
    }
}
