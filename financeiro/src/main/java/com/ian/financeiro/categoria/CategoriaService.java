package com.ian.financeiro.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;

    public List<Categoria> listAll() {
        return repository.findAll();
    }

    public void save(Categoria categoria) {
        repository.save(categoria);
    }

    public Categoria get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
