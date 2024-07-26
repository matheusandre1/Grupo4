package br.com.squad04.consultoria.controller;

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
import br.com.squad04.consultoria.model.Consultas;
import br.com.squad04.consultoria.model.Consultores;
import br.com.squad04.consultoria.model.Relatorios;
import br.com.squad04.consultoria.service.ClientesService;
import br.com.squad04.consultoria.service.ConsultasService;
import br.com.squad04.consultoria.service.ConsultoresService;
import br.com.squad04.consultoria.service.RelatoriosService;

@Controller
@RequestMapping("/relatorios")
public class RelatoriosController {
    @Autowired
    private RelatoriosService relatoriosService;

    @Autowired
    private ConsultoresService consultoresService;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private ConsultasService consultasService;

    @GetMapping
    public String getAllRelatorios(Model model){
        List<Relatorios> relatorios = relatoriosService.getAllRelatorios();
        model.addAttribute("relatorios", relatorios);
        return "consulta/list";
    }

    @GetMapping("/novo")
    public String showRelatorioForm(Model model){
        model.addAttribute("relatorio", new Relatorios());
        
        List<Consultores> consultores = consultoresService.getAllConsultores();
        model.addAttribute("consultores", consultores);

        List<Clientes> clientes = clientesService.getAllClientes();
        model.addAttribute("clientes", clientes);

        List<Consultas> consultas = consultasService.getAllConsultas();
        model.addAttribute("consultas", consultas);

        return "relatorio/form";
    }

    @PostMapping
    public String saveRelatorio(@ModelAttribute Relatorios relatorio){
        relatoriosService.saveRelatorio(relatorio);
        return "redirect:/consultas";
    }

    @GetMapping("/visualizar/{idRelatorio}")
    public String viewRelatorio(@PathVariable("idRelatorio") long idRelatorio, Model model){
        Relatorios relatorio = relatoriosService.getRelatorioById(idRelatorio)
            .orElseThrow(() -> new IllegalArgumentException("ID do Relatório inválido: " + idRelatorio));
        
        model.addAttribute("relatorio", relatorio);
        return "relatorio/view";
    }

    @GetMapping("/delete/{idRelatorio}")
    public String deleteRelatorio(@PathVariable("idRelatorio") long idRelatorio){
        relatoriosService.deleteRelatorio(idRelatorio);
        return "redirect:/consultas";
    }

}

