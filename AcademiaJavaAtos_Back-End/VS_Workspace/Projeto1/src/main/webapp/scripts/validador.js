/**
 * validar os campos obrigatórios
 */
 function validar(){
	let codigo = frmCadastro.codigo.value;
	let nome = frmCadastro.nome.value;
	let valor = frmCadastro.valor.value;
	let quantidade = frmCadastro.quantidade.value;
	
	
	
	if(codigo === ""){
		alert('Por favor, insira o código!')
		frmCadastro.codigo.focus()
		return false
	}else if(nome === ""){
		alert('Por favor, insira o nome!')
		frmCadastro.nome.focus()
		return false
	}else if(valor === ""){
		alert('Por favor, insira o valor!')
		frmCadastro.valor.focus()
		return false
	}else if(quantidade === ""){
		alert('Por favor, insira a quantidade!')
		frmCadastro.quantidade.focus()
		return false
	}else {
		document.forms["frmCadastro"].submit()
	}	
}