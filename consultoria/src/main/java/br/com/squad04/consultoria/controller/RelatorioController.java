package br.com.squad04.consultoria.controller;

import br.com.squad04.consultoria.model.Relatorio;
import br.com.squad04.consultoria.service.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    @Autowired
    private RelatorioService relatorioService;


    @PostMapping
    public String CriarRelatorio(@ModelAttribute Relatorio relatorio){

        relatorioService.criar(relatorio);
        return "relatorio/list";
    }

    @PutMapping("/{id}")
    public String editarRelatorio(@PathVariable Long id, Relatorio relatorio){
        relatorioService.editar(relatorio);
        return "relatorio/view";
    }



}
