package br.com.squad04.consultoria.controller;

import br.com.squad04.consultoria.model.Clientes;
import br.com.squad04.consultoria.service.IClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

    @Autowired
    private IClientesService iClientesService;


    @GetMapping
    public String getAllClientes(Model model) {
        List<Clientes> clientes = iClientesService.getAllClientes();
        model.addAttribute("clientes", clientes);
        return "clientes/list";
    }

    @GetMapping("/novo")
    public String showForm(Clientes cliente) {
        return "clientes/form";
    }

    @PostMapping("/clientes")
    public String saveCliente(@ModelAttribute Clientes cliente) {
        cliente.setDataCadastro(LocalDate.now());
        iClientesService.saveCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/visualizar/{idCliente}")
    public String viewCliente(@PathVariable("idCliente") long idCliente, Model model) {
        Clientes cliente = iClientesService.getClienteById(idCliente)
                .orElseThrow(() -> new IllegalArgumentException("ID da Cliente inválido: " + idCliente));
        model.addAttribute("cliente", cliente);
        return "clientes/view";
    }

    @GetMapping("/editar/{idCliente}")
    public String showUpdateForm(@PathVariable("idCliente") long idCliente, Model model) {
        Clientes cliente = iClientesService.getClienteById(idCliente)
                .orElseThrow(() -> new IllegalArgumentException("ID da Cliente inválido: " + idCliente));
        model.addAttribute("cliente", cliente);
        return "clientes/form";
    }

    @GetMapping("/deletar/{idCliente}")
    public String deleteCliente(@PathVariable("idCliente") long idCliente) {
        iClientesService.deleteCliente(idCliente);
        return "redirect:/clientes";
    }

}