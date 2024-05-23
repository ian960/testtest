package com.ian.financeiro.categoria;

import com.ian.financeiro.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
