package com.example.tudoemais.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    // Nada a declarar aqui por enquanto. Os métodos padrão já resolvem.
}
