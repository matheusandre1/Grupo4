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
@RequestMapping("/consultas")
public class ConsultasController {
    @Autowired
    private ConsultasService consultasService;

    @Autowired
    private ConsultoresService consultoresService;

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private RelatoriosService relatoriosService;

    @GetMapping
    public String getAllConsultas(Model model){
        List<Consultas> consultas = consultasService.getAllConsultas();
        model.addAttribute("consultas", consultas);
        List<Relatorios> relatorios = relatoriosService.getAllRelatorios();
        model.addAttribute("relatorios", relatorios);
        return "consulta/list";
    }

    @GetMapping("/nova")
    public String showConsultaForm(Model model){
        model.addAttribute("consultas", new Consultas());
        
        List<Consultores> consultor = consultoresService.getAllConsultores();
        model.addAttribute("consultor", consultor);

        List<Clientes> cliente = clientesService.getAllClientes();
        model.addAttribute("cliente", cliente);

        return "consulta/form";
    } 
    
    @PostMapping
    public String saveConsultas(@ModelAttribute Consultas consulta){
        consultasService.saveConsulta(consulta);
        return "redirect:/consultas";
    }



    @GetMapping("/editar/{idConsulta}")
    public String showUpdateConsultaForm(@PathVariable("idConsulta") long idConsulta, Model model){
        Consultas consulta = consultasService.getConsultaById(idConsulta).orElseThrow(()-> new IllegalArgumentException("ID da Consulta Inválido: " + idConsulta));
        model.addAttribute("consultas", consulta);
        
        List<Consultores> consultor = consultoresService.getAllConsultores();
        model.addAttribute("consultor", consultor);

        List<Clientes> cliente = clientesService.getAllClientes();
        model.addAttribute("cliente", cliente);
        return "consulta/form";
    }

    @GetMapping("/delete/{idConsulta}")
    public String deleteConsulta(@PathVariable("idConsulta") long idConsulta){
        consultasService.deleteConsulta(idConsulta);
        return "redirect:/consultas";
    }

}
