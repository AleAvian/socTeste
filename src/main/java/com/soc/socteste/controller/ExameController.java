package com.soc.socteste.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.soc.socteste.dto.ExameDTO;
import com.soc.socteste.service.ExameService;

@Controller
@RequestMapping("/exame")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @GetMapping("/lista")
    public String listaExames(Model model){

        boolean status = model.asMap().get("addExameSuccess") == null || (boolean)model.asMap().get("addExameSuccess");
        model.addAttribute("exames", exameService.buscarListaExames());
        model.addAttribute("status", status);
        return "lista-exames";
    }

    @GetMapping("/criar")
    public String criarExameView(Model model){
        model.addAttribute("exame", new ExameDTO());
        return "criar-exame";
    }


    @PostMapping("/criar")
    public RedirectView criarExame(@ModelAttribute("exame") ExameDTO exame, RedirectAttributes redirectAttributes){
        final RedirectView redirectView = new RedirectView("/exame/lista", true);
        boolean status = false;
        try {
            status = exameService.criarExame(exame);
        } catch (ParseException e) {
            status = false;
        }
        redirectAttributes.addFlashAttribute("addExameSuccess", status);
        return redirectView;
    }
}
