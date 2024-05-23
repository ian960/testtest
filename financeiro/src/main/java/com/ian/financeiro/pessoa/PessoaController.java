package com.ian.financeiro.pessoa;

import com.ian.financeiro.pessoa.Pessoa;
import com.ian.financeiro.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PessoaController {
    @Autowired
    private PessoaService service;

    @GetMapping("/pessoas")
    public String showPessoaList(Model model) {
        List<Pessoa> listPessoas = service.listAll();
        model.addAttribute("listPessoas", listPessoas);
        return "pessoas";
    }

    @GetMapping("/pessoas/new")
    public String showNewForm(Model model) {
        model.addAttribute("pessoa", new Pessoa());
        return "pessoa_form";
    }

    @PostMapping("/pessoas/save")
    public String savePessoa(Pessoa pessoa) {
        service.save(pessoa);
        return "redirect:/pessoas";
    }

    @GetMapping("/pessoas/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Pessoa pessoa = service.get(id);
        model.addAttribute("pessoa", pessoa);
        return "pessoa_form";
    }

    @GetMapping("/pessoas/delete/{id}")
    public String deletePessoa(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/pessoas";
    }
}
