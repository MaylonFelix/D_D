package br.com.pix.mvc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.pix.logica.Logica;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	private static final String ERRO_EXCECAO_LOGICA_NEGOCIO = "erro.excecao.logica_negocio";
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

		Locale ptBR = new Locale("pt", "BR");
		ResourceBundle bundle = ResourceBundle.getBundle("messages", ptBR);

		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();

		// PRECISA SER DFINIDO ASSIM ANTES LER O QUE VEIO DO NAVEGADOR
		String enc = request.getCharacterEncoding();
		if (enc == null)
			request.setCharacterEncoding("UTF-8");

		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.pix.logica." + parametro;

		try {
			Class<?> classe = Class.forName(nomeDaClasse);

			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);

			request.getRequestDispatcher(pagina).forward(request, response);

		} catch (Exception e) {
			throw new ServletException(bundle.getString(ERRO_EXCECAO_LOGICA_NEGOCIO), e);
		}

	}

}
