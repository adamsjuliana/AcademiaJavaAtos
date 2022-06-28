package com.example.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/*PersonItemProcessor implementa a interface ItemProcessor do Spring Batch. 
 * Isso facilita a conexão do código em um trabalho em lote que você definirá 
 * posteriormente neste guia. De acordo com a interface, você recebe um objeto 
 * Person de entrada, após o qual você o transforma em uma pessoa maiúscula.
 */

public class PersonItemProcessor implements ItemProcessor<Person, Person> {
	
	private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);
	
	@Override
	public Person process(final Person person) throws Exception {
		final String firstName = person.getFirstName().toUpperCase();
	    final String lastName = person.getLastName().toUpperCase();

	    final Person transformedPerson = new Person(firstName, lastName);
	    
	    log.info("Converting (" + person + ") into (" + transformedPerson + ")");
	    
		return transformedPerson;
	}
}
