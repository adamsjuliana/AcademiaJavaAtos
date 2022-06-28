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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.adams.exemploSprintJPARest.Models.Produto;
import com.adams.exemploSprintJPARest.Repositories.ProdutoRepository;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoRepository produtoRepository;
	@RequestMapping("/")
	public String pagInicial() {
		return "homeProdutos";
	}
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
    @GetMapping("/listar")
    public String listProdutos() {
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
    @GetMapping("/alterar/{id}")
    public String altProdutos(@PathVariable Long id, Model model) {
    	Produto p = produtoRepository.findById(id).get();
    	model.addAttribute("produto",p);
    	return "alterarProduto";
    }
    @PostMapping("/alterar")
    @ResponseStatus(HttpStatus.OK)
    public String updateProduto(@ModelAttribute Produto novoProduto, Model model) {
    	Produto p = produtoRepository.findById(novoProduto.getId()).get();
    	p.setNome(novoProduto.getNome());
    	p.setCodigo(novoProduto.getCodigo());
    	p.setCategoria(novoProduto.getCategoria());
    	p.setValor(novoProduto.getValor());
    	p.setQuantidade(novoProduto.getQuantidade());
    	produtoRepository.save(p);
    	List<Produto> listaProdutos = produtoRepository.findAll();
    	model.addAttribute("produtos", listaProdutos);
    	return "listarProdutos";
    }
}
