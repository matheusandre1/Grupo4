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

import br.com.squad04.consultoria.model.Consultor;
import br.com.squad04.consultoria.service.ConsultorService;

@Controller
@RequestMapping("/consultores")
public class ConsultorController {
    @Autowired
    private ConsultorService consultorService;

    @GetMapping
    public String getAllConsultores(Model model){
        List<Consultor> consultores = consultorService.getAllConsultores();
        model.addAttribute("consultores", consultores);
        return "consultor/list";
    }

    @GetMapping("/novo")
    public String showForm(Consultor consultor){
        return "consultor/form";
    }

    @PostMapping
    public String saveConsultor(@ModelAttribute Consultor consultor){
        // Atualiza o timestamp de dataCadastro
        consultor.setDataCadastro(new Timestamp(System.currentTimeMillis()));
        consultorService.saveConsultor(consultor);
        return "redirect:/consultores";
    }

    @GetMapping("/visualizar/{idConsultor}")
    public String viewConsultor(@PathVariable("idConsultor") long idConsultor, Model model){
        Consultor consultor = consultorService.getConsultorById(idConsultor)
            .orElseThrow(() -> new IllegalArgumentException("ID do Consultor inválida: " + idConsultor));
        model.addAttribute("consultor", consultor);
        return "consultor/view";
    }

    @GetMapping("editar/{idConsultor}")
    public String showUpdateForm(@PathVariable("idConsultor") long idConsultor, Model model){
        Consultor consultor = consultorService.getConsultorById(idConsultor).orElseThrow(() -> new IllegalArgumentException("ID do Consultor inválida: " + idConsultor));
        model.addAttribute("consultor", consultor);
        return "consultor/form";
    }

    @GetMapping("/deletar/{idConsultor}")
    public String deleteConsultor(@PathVariable("idConsultor") long idConsultor){
        consultorService.deleteConsultor(idConsultor);
        return "redirect:/consultores";
    }
}
