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
    <!---CSS--->
    <link rel="stylesheet" href="css/style.css">
    <!---FONTAWESOME--->
    <script src="https://kit.fontawesome.com/0a84b03181.js" crossorigin="anonymous"></script>
    <title>Visualizar</title>
</head>
<body>
    <nav class="sidebar">
        <header>
            <div class="image-text">
                <span class="image">
                    <img src="imagens/Logo.png" alt="logo">
                </span>

                <div class="text header-text">
                    <span class="academia">Academia Java</span>
                    <span class="by">Atos - UFN</span>
                </div>
                
            </div>
        </header>
        <div class="menu-bar">
            <ul class="menu-links">
                <li class="nav-link">
                    <a href="home">
                        <i class="fa-solid fa-house-user icon"></i>
                        <span class="text nav-text">Página Inicial</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="create">
                        <i class="fa-solid fa-cart-plus icon"></i>
                        <span class="text nav-text">Cadastrar</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="read">
                        <i class="fa-solid fa-rectangle-list icon"></i>
                        <span class="text nav-text">Visualizar</span>
                    </a>
                </li>
            </ul>

        </div>
    </nav>
        <div class="home">
            	
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
					<td><a href="javascript: confirmar(<%=lista.get(i).getId()%>)" style="color:red;"><i class="fa-solid fa-xmark"></i></a></td>
					<td><a href="select?id=<%=lista.get(i).getId()%>" style="color:grey;"><i class="fa-solid fa-pen-to-square"></i></a></td>
				</tr>
				<%} %>
		</tbody>
	</table>
	<div>
	<input type="button" value="<<Voltar" onclick="volta()">
	<script src="scripts/confirmador.js"></script>
	<script src="scripts/volta.js"></script>
	</div>
	</form>
</main>
</body>
</html>