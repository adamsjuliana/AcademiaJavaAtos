<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="model.JavaBeans" %>
    <%@page import="java.util.ArrayList" %>
    
    <%
    	@ SuppressWarnings("unchecked")
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
    %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visualizar</title>
    <script src="https://kit.fontawesome.com/0a84b03181.js" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="css/style.css" class="css">
<body>
<main class="container">
	<h1>Visualizar</h1>
	<form>
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Código</th>
				<th>Nome</th>
				<th>Categorial</th>
				<th>Valor</th>
				<th>Quantidade</th>
				<th>Deletar</th>
				<th>Editar</th>
			</tr>
		</thead>
		</div>
		<div>
	
		<tbody>
			<%for(int i=0; i<lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getId() %></td>
					<td><%=lista.get(i).getCodigo() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getCategoria() %></td>
					<td><%=lista.get(i).getValor() %></td>
					<td><%=lista.get(i).getQuantidade() %></td>
					<td><a href="javascript: confirmar(<%=lista.get(i).getId()%>)"><i class="fa-solid fa-xmark"></i></a></td>
					<td><a href="select?id=<%=lista.get(i).getId()%>"><i class="fa-solid fa-pen-to-square"></i></a></td>
				</tr>
				<%} %>
		</tbody>
	</table>
	<div>
	<input type="button" value="Voltar" onclick="location.href='home';">
	<script src="scripts/confirmador.js"></script>
	</div>
	</form>
</main>
</body>
</html>