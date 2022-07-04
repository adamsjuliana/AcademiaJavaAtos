package com.JpaAnnotation.BancoJava.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.JpaAnnotation.BancoJava.Models.Conta;
import com.JpaAnnotation.BancoJava.Repositories.ContaRepository;


//{"nomeCompleto": "Paulo Ricardo", "numeroConta": 944, "saldoConta": 2437.0, "filial":{"id":1}}
@RestController
public class ControllerConta {
	@Autowired
	private ContaRepository contaRepository;

	@PostMapping("/contas")//salva uma nova conta no BD. Observar o JSON para enviar as informaçoes da Filial
	@ResponseStatus(HttpStatus.CREATED)
	public Conta adicionarConta(@RequestBody Conta conta) {
		contaRepository.save(conta);
		return conta;
	}

	@GetMapping("/contas")//lista as contas e as respectivas filiais
	public List<Conta> listarContas() {
		return contaRepository.findAll();
	}
}
