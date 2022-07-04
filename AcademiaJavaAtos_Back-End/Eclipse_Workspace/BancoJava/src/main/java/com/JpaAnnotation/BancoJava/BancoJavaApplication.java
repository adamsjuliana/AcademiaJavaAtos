package com.JpaAnnotation.BancoJava;

import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.JpaAnnotation.BancoJava.Models.Conta;
import com.JpaAnnotation.BancoJava.Models.Filial;
import com.JpaAnnotation.BancoJava.Repositories.ContaRepository;
import com.JpaAnnotation.BancoJava.Repositories.FilialRepository;

@SpringBootApplication
public class BancoJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BancoJavaApplication.class, args);
	}

	@Bean // Bean para adicionar dados as tabelas filial e conta ao rodar a aplicação
	public CommandLineRunner mappingDemo(ContaRepository contaRepository, FilialRepository filialRepository) {
		return args -> {

			// cria uma nova filial
			Filial f = new Filial(null, Long.parseLong("123"), "Santa Maria/RS");

			// salva a filial no BD
			filialRepository.save(f);

			// cria novas contas
			Conta c1 = new Conta(null, Long.parseLong("98765"), "João Batista", Float.parseFloat("10000000"), f);
			Conta c2 = new Conta(null, Long.parseLong("98763"), "Paulo Ricardo", Float.parseFloat("1000"), f);
			Conta c3 = new Conta(null, Long.parseLong("223344"), "João Ricardo", Float.parseFloat("10000"), f);
			// salva contas no BD
			contaRepository.saveAll(Arrays.asList(c1, c2, c3));
		};
	}
}
