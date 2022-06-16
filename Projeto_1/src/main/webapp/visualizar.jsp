<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.Produtos"%>
<%@page import="java.util.ArrayList"%>

<%
@SuppressWarnings("unchecked")
ArrayList<Produtos> lista = (ArrayList<Produtos>) request.getAttribute("produtos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!---CSS--->
<link rel="stylesheet" href="css/style.css">
<!---FONTAWESOME--->
<script src="https://kit.fontawesome.com/0a84b03181.js"></script>
<title>Visualizar</title>
</head>
<body>
	<header class="cabecalho">
		<h2 class="cabecalho-titulo">Visualizar</h2>
		<nav class="cabecalho-menu">
			<a class="cabecalho-menu-item" href="home">Página Inicial</a>  <a
				class="cabecalho-menu-item" href="create">Cadastrar</a> <a
				class="cabecalho-menu-item" href="read">Visualizar</a>
		</nav>
	</header>

	<main class="conteudo">
		<section class="conteudo-principal">
			<div class="conteudo-principal-escrito">
				<form>
					<table>
						<thead>
							<tr>

								<th>Código</th>
								<th>Nome</th>
								<th>Categorial</th>
								<th>Valor</th>
								<th>Quantidade</th>
								<th>Deletar</th>
								<th>Editar</th>
							</tr>
						</thead>

						<tbody>
							<%
							for (int i = 0; i < lista.size(); i++) {
							%>
							<tr>

								<td><%=lista.get(i).getCodigo()%></td>
								<td><%=lista.get(i).getNome()%></td>
								<td><%=lista.get(i).getCategoria()%></td>
								<td><%=lista.get(i).getValor()%></td>
								<td><%=lista.get(i).getQuantidade()%></td>
								<td><a
									href="javascript: confirmar(<%=lista.get(i).getId()%>)"
									style="color: red;"><i class="fa-solid fa-trash-can"></i></a></td>
								<td><a href="select?id=<%=lista.get(i).getId()%>"
									style="color: grey;"><i class="fa-solid fa-pen"></i></a></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
					<script src="scripts/confirmador.js"></script>
				</form>

			</div>
		</section>
	</main>

	<footer class="rodape">
		<img src="imagens/LogoR.png" class="rodape-img" alt="Logo">
		<h3 class="rodape-titulo">Projeto 1 Academia Java Atos - UFN.</h3>
	</footer>
</body>
</html>