package com.example.tudoemais.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public void inserirCategoria(Categoria cat) {
        categoriaRepository.save(cat);
    }

    public Categoria buscarPorId(int id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public List<Categoria> listarTodasCategorias() {
        return categoriaRepository.findAll();
    }

    public void deletarCategoria(int id) {
        categoriaRepository.deleteById(id);
    }
}
