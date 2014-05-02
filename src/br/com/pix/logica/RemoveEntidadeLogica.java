package br.com.pix.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pix.model.Entidade;
import br.com.pix.persistence.EntidadeDAO;

public class RemoveEntidadeLogica implements Logica {

	@Override
	public String executa(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));

		Entidade entidade = new Entidade();
		entidade.setId(id);

		// busca a conexão pendurada na requisição
		Connection connection = (Connection) request.getAttribute("conexao");

		// passe a conexão no construtor
		EntidadeDAO dao = new EntidadeDAO(connection);
		dao.exclui(entidade);

		System.out.println("Excluindo entidade... ");

		return "mvc?logica=ListaEntidadeLogica";
	}

}
