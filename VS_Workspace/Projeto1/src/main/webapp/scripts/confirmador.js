/**
 * COnfirmação de exclusão de um contato
 */
 function confirmar(id){
	let resposta = confirm("Deseja deletar este produto?")
	
	if(resposta === true){
		window.location.href = "delete?id=" + id
	}
}