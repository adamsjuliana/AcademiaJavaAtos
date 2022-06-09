package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/home", "/create", "/read", "/delete", "/insert", "/edit", "/select", "/update", "/about"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO(); //Objeto de acesso ao bd
	JavaBeans produto = new JavaBeans(); //Objeto para armazenar dados temporariamente
	
       
public Controller() {
        super();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		if(action.equals("/home")) {
		response.sendRedirect("index.html");
		}
		else if(action.equals("/create")) {
		response.sendRedirect("cadastrar.html");
		}
		else if(action.equals("/about")) {
		response.sendRedirect("sobre.html");
		}
		else if(action.equals("/read")) {
		listarProdutos(request, response);
		response.sendRedirect("visualizar.jsp");
		}
		else if (action.equals("/insert")) {
		adicionarProdutos(request, response);
		}
		else if (action.equals("/delete")) {
		removerProdutos(request, response);
		}
		else if(action.equals("/update")) {
		editandoProdutos(request,response);
		}
		else if(action.equals("/select")) {
		recuperarProdutos(request,response);
		}
		}

protected void adicionarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//System.out.println("Nome: " + request.getParameter("nome"));
	produto.setCodigo(request.getParameter("codigo"));
	produto.setNome(request.getParameter("nome"));
	produto.setCategoria(request.getParameter("categoria"));
	produto.setValor(request.getParameter("valor".replaceAll(",", ".")));
	produto.setQuantidade(request.getParameter("quantidade"));
	dao.inserirProduto(produto);
	response.sendRedirect("read");
}

protected void editandoProdutos(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	//System.out.println(request.getParameter("id"));
	produto.setId(request.getParameter("id"));
	produto.setCodigo(request.getParameter("codigo"));
	produto.setNome(request.getParameter("nome"));
	produto.setCategoria(request.getParameter("categoria"));
	produto.setValor(request.getParameter("valor"));
	produto.setQuantidade(request.getParameter("quantidade"));
	//executar o metodo de alterar aluno
	dao.alterarProduto(produto);
	//redirecionar para o documento alunos.jsp atulaiznaod as asltera��es
	response.sendRedirect("read");
}

protected void listarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	ArrayList<JavaBeans> lista = dao.listarProdutos();
	request.setAttribute("produtos", lista);
	RequestDispatcher rd = request.getRequestDispatcher("visualizar.jsp");
	rd.forward(request, response);	
}

protected void recuperarProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	produto.setId(id);
	dao.selecionarProduto(produto);
	request.setAttribute("id", produto.getId());
	request.setAttribute("codigo", produto.getCodigo());
	request.setAttribute("nome", produto.getNome());
	request.setAttribute("categoria", produto.getCategoria());
	request.setAttribute("valor", produto.getValor());
	request.setAttribute("quantidade", produto.getQuantidade());
	RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
	rd.forward(request, response);	
}

protected void removerProdutos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	produto.setId(id);
	dao.deletarProduto(produto);
	response.sendRedirect("read");
}

}
