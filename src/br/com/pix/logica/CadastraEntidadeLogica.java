package br.com.pix.logica;

import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pix.model.Entidade;
import br.com.pix.persistence.EntidadeDAO;

public class CadastraEntidadeLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
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

		return "/jsp/resultado_cadastra_entidade.jsp";
	}
}