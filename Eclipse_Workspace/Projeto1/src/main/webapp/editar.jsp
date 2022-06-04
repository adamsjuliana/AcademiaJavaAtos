<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="model.JavaBeans" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar</title>
	<link rel="stylesheet" href="css/style.css" class="css">
</head>
<body>

<main class="container">
    <h1>Editar</h1>
    <form name="frmCadastro" action = "update">
        <div class="caixinha">
            <input type="text" id="id" class="text" name="id"
            placeholder="Insira o id" value="<%out.print(request.getAttribute("id"));%>">
        </div>
        <div class="caixinha">
            <input type="text" id="codigo" class="text" name="codigo"
            placeholder="Insira o código" value="<%out.print(request.getAttribute("codigo"));%>">      
        </div>
        <div class="caixinha">
            <input type="text" id="nome" class="text" name="nome"
            placeholder="Insira o nome"  value="<%out.print(request.getAttribute("nome"));%>">
        </div>
        <div class="caixinha">
            <input type="text" id="categoria" class="text" name="categoria"
            placeholder="Insira a categoria"  value="<%out.print(request.getAttribute("categoria"));%>">
        </div>
        <div class="caixinha">
            <input type="text" id="valor" class="text" name="valor"
            placeholder="Insira o valor em R$"  value="<%out.print(request.getAttribute("valor"));%>">
        </div>
        <div class="caixinha">
            <input type="text" id="quantidade" class="text" name="quantidade"
            placeholder="Insira a quantidade"  value="<%out.print(request.getAttribute("quantidade"));%>">
        </div>
            <input type="button" value="Salvar" onclick="validar()">
            <input type="reset" value="Limpar">
            <script src="scripts/validador.js"></script>
        <div>
			<input type="button" value="Voltar" onclick="location.href='home';">
        </div>
    </form>
</main>
</body>
</html>