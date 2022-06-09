package com.adams.exemploSprintJPARest.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.adams.exemploSprintJPARest.Models.Produto;
import com.adams.exemploSprintJPARest.Repositories.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public List<Produto> getProdutos() {
		return produtoRepository.findAll();
	}
    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }
    @DeleteMapping("/excluir/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String excluir(@PathVariable Long id) {
    	produtoRepository.deleteById(id);
    	return "main";
    }
    @GetMapping("/{id}")
    Produto getProduto(@PathVariable Long id) {
    	return produtoRepository.findById(id).get();
}
    @PutMapping("/editar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produto editar(@RequestBody Produto novoProduto, @PathVariable Long id) {
    	Produto p = produtoRepository.findById(id).get();
    	p.setNome(novoProduto.getNome());
    	p.setCodigo(novoProduto.getCodigo());
    	p.setCategoria(novoProduto.getCategoria());
    	p.setValor(novoProduto.getValor());
    	p.setQuantidade(novoProduto.getQuantidade());
    	return produtoRepository.save(p);
    }
}
