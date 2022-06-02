<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="model.JavaBeans" %>
    <%@page import="java.util.ArrayList" %>
    
    <%
    	@ SuppressWarnings("unchecked")
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("produtos");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Visualizar</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>

<body>
<main class="container">
    <h1>Visualizar</h1>
	<table>
		<thead>	
			<tr>
				<th>ID</th>
				<th>Código</th>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Valor</th>
				<th>Quantidade</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i=0; i<lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getId() %></td>
					<td><%=lista.get(i).getCodigo() %></td>
					<td><%=lista.get(i).getNome() %></td>
					<td><%=lista.get(i).getCategoria() %></td>
					<td><%=lista.get(i).getValor() %></td>
					<td><%=lista.get(i).getQuantidade() %></td>
					<td><a href="javascript: confirmar(<%=lista.get(i).getId()%>)">Excluir</a></td>
				</tr>
				<%} %>
		</tbody>
	</table>
	<p>
    <input type="button" value="Home" onclick="location.href='home';"> 
	<script src="scripts/confirmador.js"></script>
            
    
</main>
    
</body>
</html>
<body>


</body>
</html>