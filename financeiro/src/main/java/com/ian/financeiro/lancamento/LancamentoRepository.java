package com.ian.financeiro.lancamento;

import com.ian.financeiro.lancamento.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
