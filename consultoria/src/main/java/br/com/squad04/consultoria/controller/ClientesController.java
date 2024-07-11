package br.com.squad04.consultoria.controller;

import br.com.squad04.consultoria.model.Clientes;
import br.com.squad04.consultoria.service.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
//
//@Controller
//public class ClientesController {
//
//    @Autowired
//    private IClientesService iClientesService;
//
//    @PostMapping("/clientes")
//    public ResponseEntity<String> cadastrarCliente(@RequestBody Clientes cliente) {
//        try {
//            ResponseEntity<?> resposta = iClientesService.cadastrarCliente(cliente);
//            // Verifica se o corpo da resposta não é nulo antes de chamá-lo
//            String responseBody = resposta.getBody() != null ? resposta.getBody().toString() : "";
//            return ResponseEntity.status(resposta.getStatusCode()).body(responseBody);
//        } catch (Exception e) {
//            // Log da exceção para fins de depuração
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o cliente.");
//        }
//    }
//
//    @GetMapping("/clientes")
//    public ResponseEntity<ArrayList<Clientes>> listarClientes() {
//        ArrayList<Clientes> clientes= (ArrayList<Clientes>) iClientesService.recuperarClientes();
//        return ResponseEntity.ok(clientes);
//    }
//
//    @GetMapping("cliente/{idCliente}")
//    public ResponseEntity<Clientes> buscarCliente(@PathVariable("idCliente") int idCliente) {
//        Clientes cliente = iClientesService.buscarCliente(idCliente);
//        if (cliente != null) {
//            return ResponseEntity.ok(cliente);
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
//        }
//    }
//
//    @PutMapping("/{idCliente}")
//    public ResponseEntity<String> atualizarCliente(@PathVariable("idCliente") int idCliente, @RequestBody Clientes cliente) {
//        try {
//            ResponseEntity<?> resposta = iClientesService.atualizarCliente(cliente);
//            String responseBody = resposta.getBody() != null ? resposta.getBody().toString() : "";
//            return ResponseEntity.status(resposta.getStatusCode()).body(responseBody);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao atualizar o cliente.");
//        }
//    }
//
//    @DeleteMapping("/{idCliente}")
//    public ResponseEntity<String> deletarCliente(@PathVariable("idCliente") int idCliente) {
//        try {
//            ResponseEntity<?> resposta = iClientesService.deletarCliente(idCliente);
//            String responseBody = resposta.getBody() != null ? resposta.getBody().toString() : "";
//            return ResponseEntity.status(resposta.getStatusCode()).body(responseBody);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao excluir o cliente.");
//        }
//    }
//}



@Controller
@RequestMapping("/templates/clientes")
public class ClientesController {

    @Autowired
    private IClientesService iClientesService;


    @GetMapping
     public String getAllClientes(Model model) {
        List<Clientes> clientes = iClientesService.getAllClientes();
        model.addAttribute("templates/clientes", clientes);
        return "cliente/list";
    }


      @GetMapping("/nova")
      public String showForm(Clientes cliente) {
          return "cliente/form";
      }

      @PostMapping("/templates/clientes")
      public String saveCliente(@ModelAttribute Clientes cliente) {
        cliente.setDataCadastro(LocalDate.now());
          iClientesService.saveCliente(cliente);
        return "redirect:/clientes";
      }

      @GetMapping("/visualizar/{idCliente}")
      public String viewCliente(@PathVariable("idCliente") int idCliente, Model model) {
          Clientes cliente = iClientesService.getClienteById(idCliente)
                 .orElseThrow(() -> new IllegalArgumentException("ID da Cliente inválido: " + idCliente));
          model.addAttribute("cliente", cliente);
          return "cliente/view";
      }

      @GetMapping("/editar/{idCliente}")
      public String showUpdateForm(@PathVariable("idCliente") int idCliente, Model model) {
          Clientes cliente = iClientesService.getClienteById(idCliente)
                  .orElseThrow(() -> new IllegalArgumentException("ID da Cliente inválido: " + idCliente));
          model.addAttribute("cliente", cliente);
          return "cliente/form";
      }

      @GetMapping("/deletar/{idCliente}")
      public String deleteCliente(@PathVariable("idCliente") int idCliente) {
          iClientesService.deleteCliente(idCliente);
          return "redirect:/clientes";
      }

}