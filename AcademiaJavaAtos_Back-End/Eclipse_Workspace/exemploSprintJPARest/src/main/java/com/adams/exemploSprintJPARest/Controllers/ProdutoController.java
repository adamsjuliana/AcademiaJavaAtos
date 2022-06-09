package com.adams.exemploSprintJPARest.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.adams.exemploSprintJPARest.Models.Produto;
import com.adams.exemploSprintJPARest.Repositories.ProdutoRepository;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping("/cadastrar")
	public String getProdutos(Model model) {
		model.addAttribute("produto", new Produto());
		return "cadastrarProduto";
	}
    @PostMapping("/cadastrar")
    public String setProdutos(@ModelAttribute Produto produto, Model model) {
        produtoRepository.save(produto);
        List<Produto> listaProdutos = produtoRepository.findAll();
        model.addAttribute("produtos", listaProdutos);
        return "listarProdutos";
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
