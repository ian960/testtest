package com.ian.financeiro.pessoa;

import com.ian.financeiro.pessoa.Pessoa;
import com.ian.financeiro.pessoa.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> listAll() {
        return repository.findAll();
    }

    public void save(Pessoa pessoa) {
        repository.save(pessoa);
    }

    public Pessoa get(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa not found"));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
