<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="model.JavaBeans" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/style.css">
    <title>Editar</title>
</head>
<body>
    <header class="cabecalho">
        <h2 class="cabecalho-titulo">Editar</h2>
        <nav class="cabecalho-menu">
            <a class="cabecalho-menu-item" href="home">Página Inicial</a>
            <a class="cabecalho-menu-item" href="about">Sobre</a>
            <a class="cabecalho-menu-item" href="create">Cadastrar</a>
            <a class="cabecalho-menu-item" href="read">Visualizar</a>
        </nav>
    </header>

    <main class="conteudo">
        <section class="conteudo-principal">
            <div class="conteudo-principal-escrito">
                <form name="frmCadastro" action = "update">

                        <input type="hidden" class="conteudo-principal-escrito-input" name="id"
                        placeholder="Insira o id" value="<%out.print(request.getAttribute("id"));%>">

                    <div class="conteudo-principal-escrito-form">
                        <label class="conteudo-principal-escrito-label">Código</label>
                        <input type="number" class="conteudo-principal-escrito-input" name="codigo"
                        placeholder="Insira o código" min="0" value="<%out.print(request.getAttribute("codigo"));%>">
                    </div>
                    <div class="conteudo-principal-escrito-form">
                        <label class="conteudo-principal-escrito-label">Nome</label>
                        <input type="text" class="conteudo-principal-escrito-input" name="nome"
                        placeholder="Insira o nome" maxlength="50" value="<%out.print(request.getAttribute("nome"));%>">
                    </div>
                    <div class="conteudo-principal-escrito-form">
                        <label class="conteudo-principal-escrito-label">Categoria</label>
                        <input type="text" class="conteudo-principal-escrito-input" name="categoria"
                        placeholder="Insira a categoria" value="<%out.print(request.getAttribute("categoria"));%>">
                    </div>
                    <div class="conteudo-principal-escrito-form">
                        <label class="conteudo-principal-escrito-label">Valor</label>
                        <input type="number" class="conteudo-principal-escrito-input" name="valor"
                        placeholder="Insira o valor em R$" min="0" step="0.01" value="<%out.print(request.getAttribute("valor"));%>"> 
                    </div>
                    <div class="conteudo-principal-escrito-form">
                        <label class="conteudo-principal-escrito-label">Quantidade</label>
                        <input type="number" class="conteudo-principal-escrito-input" name="quantidade"
                        placeholder="Insira a quantidade" min="0" value="<%out.print(request.getAttribute("quantidade"));%>">
                    </div>
                    <div class="conteudo-principal-escrito-botao">
                        <input type="reset" class="conteudo-principal-escrito-botao1" value="Limpar">
                        <input type="button" class="conteudo-principal-escrito-botao1" value="Salvar" onclick="validar()">
                    </div>   
                    <div class="conteudo-principal-escrito-botao2">
                        <input type="button" class="conteudo-principal-escrito-botao1" value="Voltar" onclick="voltar()">
                    </div>
                </form>
            </div>
        </section>
    </main>
    <footer class="rodape">
        <img src="imagens/LogoR.png" class="rodape-img" alt="Logo"><h3 class="rodape-titulo">Projeto 1 Academia Java Atos - UFN.</h3>
    </footer>
    <script src="scripts/validador.js"></script>
    <script src="scripts/voltador.js"></script>
</body>
</html>