package br.com.pix.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pix.model.Entidade;
import br.com.pix.persistence.EntidadeDAO;

/**
 * Servlet implementation class CadastraEntidade
 */
@WebServlet("/CadastraEntidade")
public class CadastraEntidade extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// PRECISA SER DEFINIDO ASSIM ANTES DE ANDAR RSPOSTA PARA O NAVEGADOR
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();

		// PRECISA SER DFINIDO ASSIM ANTES LER O QUE VEIO DO NAVEGADOR
		String enc = request.getCharacterEncoding();
		if (enc == null)
			request.setCharacterEncoding("UTF-8");

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");

		// busca a conexão pendurada na requisição
		Connection connection = (Connection) request.getAttribute("conexao");

		// passe a conexão no construtor
		EntidadeDAO dao = new EntidadeDAO(connection);

		Entidade entidade = new Entidade();
		entidade.setNome(nome);
		entidade.setDescricao(descricao);
		dao.adiciona(entidade);

		request.setAttribute("entidade", entidade);

		RequestDispatcher rd = request
				.getRequestDispatcher("jsp/resultado_cadastra_entidade.jsp");

		rd.forward(request, response);
	}

}
