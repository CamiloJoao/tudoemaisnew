package com.example.tudoemais.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    List<Produto> findByCategoriaNome(String nomeCategoria);
}
