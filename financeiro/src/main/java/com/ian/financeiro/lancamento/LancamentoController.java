package com.ian.financeiro.lancamento;

import com.ian.financeiro.pessoa.Pessoa;
import com.ian.financeiro.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LancamentoController {
    @Autowired
    private LancamentoService lancamentoService;

    @Autowired
    private PessoaService pessoaService;

    @GetMapping("/lancamentos/new")
    public String showNewForm(Model model) {
        model.addAttribute("lancamento", new Lancamento());
        List<Pessoa> pessoas = pessoaService.listAll();
        model.addAttribute("pessoas", pessoas);
        return "lancamento_form";
    }

    @PostMapping("/lancamentos/save")
    public String saveLancamento(@ModelAttribute("lancamento") Lancamento lancamento) {
        lancamentoService.save(lancamento);
        return "redirect:/lancamentos";
    }

    @GetMapping("/lancamentos")
    public String showLancamentoList(Model model) {
        List<Lancamento> listLancamentos = lancamentoService.listAll();
        model.addAttribute("listLancamentos", listLancamentos);
        return "lancamentos";
    }

    @GetMapping("/lancamentos/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Lancamento lancamento = lancamentoService.get(id);
        model.addAttribute("lancamento", lancamento);
        return "lancamento_form";
    }

    @GetMapping("/lancamentos/delete/{id}")
    public String deleteLancamento(@PathVariable("id") Long id) {
        lancamentoService.delete(id);
        return "redirect:/lancamentos";
    }
}