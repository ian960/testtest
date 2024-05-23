package com.ian.financeiro.lancamento;


import com.ian.financeiro.lancamento.Lancamento;
import com.ian.financeiro.lancamento.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository repository;

    public List<Lancamento> listAll() {
        return repository.findAll();
    }

    public void save(Lancamento lancamento) {
        repository.save(lancamento);
    }

    public Lancamento get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Lancamento not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
