package com.example.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

/*
 * Agora você precisa montar o trabalho em lote real. O Spring Batch fornece 
 * muitas classes de utilitários que reduzem a necessidade de escrever 
 * código personalizado. Em vez disso, você pode se concentrar na lógica 
 * de negócios.
 * */


/*Para começar, a anotação @EnableBatchProcessing adiciona muitos beans 
 * críticos que suportam trabalhos e economizam muito trabalho. Este exemplo 
 * usa um banco de dados baseado em memória (fornecido por 
 * @EnableBatchProcessing), o que significa que, quando concluído, os dados 
 * desaparecem. Ele também autowires algumas fábricas necessárias mais abaixo.
 * */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	/*
	 * reader() cria um ItemReader. Ele procura um arquivo chamado sample-data.
	 * csv e analisa cada item de linha com informações suficientes para 
	 * transformá-lo em uma pessoa.
	 * */
	@Bean
	public FlatFileItemReader<Person> reader() {
	  return new FlatFileItemReaderBuilder<Person>()
	    .name("personItemReader")
	    .resource(new ClassPathResource("sample-data.csv"))
	    .delimited()
	    .names(new String[]{"firstName", "lastName"})
	    .fieldSetMapper(new BeanWrapperFieldSetMapper<Person>() {{
	      setTargetType(Person.class);
	    }})
	    .build();
	}
	/*
	 * processor() cria uma instância do PersonItemProcessor que você definiu
	 *  anteriormente, destinada a converter os dados em maiúsculas.
	 * */
	@Bean
	public PersonItemProcessor processor() {
	  return new PersonItemProcessor();
	}
	/*
	 * writer(DataSource) cria um ItemWriter. Este destina-se a um destino 
	 * JDBC e obtém automaticamente uma cópia do dataSource criado por 
	 * @EnableBatchProcessing. Ele inclui a instrução SQL necessária para 
	 * inserir uma única Pessoa, orientada pelas propriedades do Java bean.
	 * */
	@Bean
	public JdbcBatchItemWriter<Person> writer(DataSource dataSource) {
	  return new JdbcBatchItemWriterBuilder<Person>()
	    .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	    .sql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)")
	    .dataSource(dataSource)
	    .build();
	}
	
	
	/*
	 * O primeiro método define o trabalho e o segundo define uma única 
	 * etapa. Os trabalhos são construídos a partir de etapas, onde cada 
	 * etapa pode envolver um leitor, um processador e um escritor.
	 * 
	 * Nesta definição de tarefa, você precisa de um incrementador, pois 
	 * as tarefas usam um banco de dados para manter o estado de execução. 
	 * Você então lista cada etapa (embora este trabalho tenha apenas uma 
	 * etapa). O trabalho termina e a API Java produz um trabalho 
	 * perfeitamente configurado.
	 * 
	 * Na definição da etapa, você define a quantidade de dados a ser 
	 * gravada por vez. Nesse caso, ele grava até dez registros por vez. 
	 * Em seguida, você configura o leitor, processador e gravador usando 
	 * os beans injetados anteriormente.
	 * */
	@Bean
	public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
		return jobBuilderFactory.get("importUserJob")
			.incrementer(new RunIdIncrementer())
			.listener(listener)
			.flow(step1)
			.end()
			.build();
	}

	@Bean
	public Step step1(JdbcBatchItemWriter<Person> writer) {
	  return stepBuilderFactory.get("step1")
	    .<Person, Person> chunk(10)
	    .reader(reader())
	    .processor(processor())
	    .writer(writer)
	    .build();
	}
	/*
	 * chunk() é prefixado <Person,Person> porque é um método genérico. 
	 * Isso representa os tipos de entrada e saída de cada “pedaço” de 
	 * processamento e se alinha com ItemReader<Person> e 
	 * ItemWriter<Person>.
	 * */

}
