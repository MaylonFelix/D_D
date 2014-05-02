package br.com.pix.logica;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import br.com.pix.model.Entidade;
import br.com.pix.persistence.EntidadeDAO;

public class ListaEntidadeLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// busca a conexão pendurada na requisição
		Connection connection = (Connection) request.getAttribute("conexao");

		// passe a conexão no construtor
		EntidadeDAO dao = new EntidadeDAO(connection);

		List<Entidade> entidades = dao.getLista();

		// Guarda a lista no request
		request.setAttribute("entidades", entidades);
		System.out.println(request.getContextPath() + "(listando...)");
		return "/jsp/lista_entidades.jsp";
	}

}
