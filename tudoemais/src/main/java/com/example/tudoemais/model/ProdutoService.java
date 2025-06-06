package com.example.tudoemais.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaService categoriaService;

    public void inserir(Produto produto) {
        produtoRepository.save(produto);
    }

    public Produto converterDTOParaProduto(ProdutoDTO produtoDTO) {
        Categoria categoria = categoriaService.buscarPorId(produtoDTO.getCategoriaId());
        Produto produto = new Produto();
        produto.setNome(produtoDTO.getNome());
        produto.setDescricao(produtoDTO.getDescricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setCategoria(categoria);
        return produto;
    }

    public List<Produto> listarTodosProdutos() {
        return produtoRepository.findAll();
    }

    public void deletarProduto(int id) {
        produtoRepository.deleteById(id);
    }

    public Produto obterProduto(int id) {
        return produtoRepository.findById(id).orElse(null);
    }

    public void atualizarProduto(int id, Produto produtoAtualizado) {
        Produto existente = obterProduto(id);
        if (existente != null) {
            existente.setNome(produtoAtualizado.getNome());
            existente.setDescricao(produtoAtualizado.getDescricao());
            existente.setPreco(produtoAtualizado.getPreco());
            existente.setCategoria(produtoAtualizado.getCategoria());
            produtoRepository.save(existente);
        }
    }

    public List<Produto> listarProdutosPorCategoria(String nomeCategoria) {
        return produtoRepository.findByCategoriaNome(nomeCategoria);
    }
}
