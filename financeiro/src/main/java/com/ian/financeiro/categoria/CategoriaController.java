package com.ian.financeiro.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaService service;

    @GetMapping("/categorias")
    public String showCategoriaList(Model model) {
        List<Categoria> listCategorias = service.listAll();
        model.addAttribute("listCategorias", listCategorias);
        return "categorias";
    }

    @GetMapping("/categorias/new")
    public String showNewForm(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "categoria_form";
    }

    @PostMapping("/categorias/save")
    public String saveCategoria(@ModelAttribute("categoria") Categoria categoria) {
        service.save(categoria);
        return "redirect:/categorias";
    }

    @GetMapping("/categorias/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        Categoria categoria = service.get(id);
        model.addAttribute("categoria", categoria);
        return "categoria_form";
    }

    @GetMapping("/categorias/delete/{id}")
    public String deleteCategoria(@PathVariable("id") Long id) {
        service.delete(id);
        return "redirect:/categorias";
    }
}
