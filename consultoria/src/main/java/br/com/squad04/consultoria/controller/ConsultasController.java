package br.com.squad04.consultoria.controller;

import br.com.squad04.consultoria.model.Consultas;
import br.com.squad04.consultoria.service.ConsultasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private ConsultasService consultasService;

    @GetMapping
    public String getAllConsultas(Model model) {
        List<Consultas> consultas = consultasService.getAllConsultas();
        model.addAttribute("consultas", consultas);
        return "consulta/list";
    }

    @GetMapping("/nova")
    public String showForm(Consultas consulta) {
        return "consulta/form";
    }

    @PostMapping
    public String saveConsulta(@ModelAttribute Consultas consulta) {
        consulta.setDataHora(LocalDateTime.now());
        consultasService.saveConsulta(consulta);
        return "redirect:/consultas";
    }

    @GetMapping("/visualizar/{idConsulta}")
    public String viewConsulta(@PathVariable("idConsulta") long idConsulta, Model model) {
        Consultas consulta = consultasService.getConsultaById(idConsulta)
                .orElseThrow(() -> new IllegalArgumentException("ID da Consulta inválida: " + idConsulta));
        model.addAttribute("consulta", consulta);
        return "consulta/view";
    }

    @GetMapping("/editar/{idConsulta}")
    public String showUpdateForm(@PathVariable("idConsulta") long idConsulta, Model model) {
        Consultas consulta = consultasService.getConsultaById(idConsulta)
                .orElseThrow(() -> new IllegalArgumentException("ID da Consulta inválida: " + idConsulta));
        model.addAttribute("consulta", consulta);
        return "consulta/form";
    }

    @GetMapping("/deletar/{idConsulta}")
    public String deleteConsulta(@PathVariable("idConsulta") long idConsulta) {
        consultasService.deleteConsulta(idConsulta);
        return "redirect:/consultas";
    }
}
