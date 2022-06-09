<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="model.JavaBeans" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!---CSS--->
    <link rel="stylesheet" href="style.css">
    <!---FONTAWESOME--->
    <script src="https://kit.fontawesome.com/0a84b03181.js" crossorigin="anonymous"></script>
    <title>Editar</title>
</head>
<body>
    <nav class="sidebar">
        <header>
            <div class="image-text">
                <span class="image">
                    <img src="imagens/logo.png" alt="logo">
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
                    <a href="#">
                        <i class="fa-solid fa-house-user icon"></i>
                        <span class="text nav-text">Página Inicial</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="#">
                        <i class="fa-solid fa-cart-plus icon"></i>
                        <span class="text nav-text">Cadastrar</span>
                    </a>
                </li>
                <li class="nav-link">
                    <a href="#">
                        <i class="fa-solid fa-rectangle-list icon"></i>
                        <span class="text nav-text">Visualizar</span>
                    </a>
                </li>
            </ul>

        </div>
    </nav>
        <div class="home">
         
<main class="container">
    <h1>Editar</h1>
    <form name="frmCadastro" action = "update">
        <div class="caixinha">
            <label>ID</label>
        <input type="text" id="id" class="text" name="id"
            placeholder="Insira o id" value="<%out.print(request.getAttribute("id"));%>">
        </div>
        <div class="caixinha">
            <label>CÓDIGO</label>
            <input type="text" id="codigo" class="text" name="codigo"
            placeholder="Insira o código" value="<%out.print(request.getAttribute("codigo"));%>">      
        </div>

        <div class="caixinha">
            <label>NOME</label>
            <input type="text" id="nome" class="text" name="nome"
            placeholder="Insira o nome"  value="<%out.print(request.getAttribute("nome"));%>">
        </div>
        <div class="caixinha">
            <label>CATEGORIA</label>
            <input type="text" id="categoria" class="text" name="categoria"
            placeholder="Insira a categoria"  value="<%out.print(request.getAttribute("categoria"));%>">
        </div>
        <div class="caixinha">
            <label>VALOR</label>
            <input type="text" id="valor" class="text" name="valor"
            placeholder="Insira o valor em R$"  value="<%out.print(request.getAttribute("valor"));%>">
        </div>
        <div class="caixinha">
            <label>QUANTIDADE</label>
            <input type="text" id="quantidade" class="text" name="quantidade"
            placeholder="Insira a quantidade"  value="<%out.print(request.getAttribute("quantidade"));%>">
        </div>
        <div class="bsalvar">
            <input type="reset" value="Limpar">
            <input type="button" value="Salvar" onclick="validar()">
        </div>
            <script src="scripts/validador.js"></script>
            <script src="scripts/volta.js"></script>
        <div>
            <input type="button" value="<< Voltar" onclick="volta()">
        </div>
    </form>
    </div>
</main>
</body>
</html>


