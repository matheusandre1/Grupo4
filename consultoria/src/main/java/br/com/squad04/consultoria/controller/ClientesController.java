package br.com.squad04.consultoria.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.squad04.consultoria.model.Clientes;
import br.com.squad04.consultoria.model.Consultores;
import br.com.squad04.consultoria.service.ClientesService;
import br.com.squad04.consultoria.service.ConsultoresService;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ConsultoresService consultoresService; // Injete o serviço de Consultor


    @GetMapping
    public String getAllClientes(Model model) {
        List<Clientes> clientes = clientesService.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "cliente/list";
    }

    @GetMapping("/novo")
    public String showClienteForm(Model model) {
        model.addAttribute("clientes", new Clientes());
        List<Consultores> consultor = consultoresService.getAllConsultores();
        model.addAttribute("consultor", consultor);
        return "cliente/form";
    }

    @PostMapping
    public String saveCliente(@ModelAttribute Clientes cliente) {
        if (cliente.getIdCliente() == null) {
            cliente.setDataCadastro(new Timestamp(System.currentTimeMillis()));
        } else {
            // Mantém a dataCadastro existente se o consultor já tiver um ID
            Clientes clienteExistente = clientesService.getClienteById(cliente.getIdCliente()).orElseThrow(() -> new IllegalArgumentException("ID do Cliente inválido: " + cliente.getIdCliente()));
            cliente.setDataCadastro(clienteExistente.getDataCadastro());
        }
        cliente.setTipoDeUsuario("Clientes");
        clientesService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{idCliente}")
    public String showUpdateClienteForm(@PathVariable("idCliente") long idCliente, Model model) {
        Clientes cliente = clientesService.getClienteById(idCliente).orElseThrow(() -> new IllegalArgumentException("ID do Cliente Inválido: " + idCliente));
        model.addAttribute("clientes", cliente);
        List<Consultores> consultor = consultoresService.getAllConsultores();
        model.addAttribute("consultor", consultor);
        return "cliente/form";
    }

    @GetMapping("/delete/{idCliente}")
    public String deleteCliente(@PathVariable("idCliente") Long idCliente) {
        clientesService.deleteCliente(idCliente);
        return "redirect:/clientes";
    }
}
