package br.com.pix.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import br.com.pix.model.Country;
import br.com.pix.persistence.ConnectionFactory;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountryInformation
 */
@WebServlet("/CountryInformation")
public class CountryInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CountryInformation() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String countryCode = request.getParameter("n");
		String countryCode2 = request.getParameter("countryCode2");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		response.setHeader("Cache-control", "no-cache, no-store");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "-1");

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST");
		response.setHeader("Access-Control-Allow-Headers", "Content-Type");
		response.setHeader("Access-Control-Max-Age", "86400");

		Gson gson = new Gson();
		JsonObject myObj = new JsonObject();

		Country countryInfo = getInfo(countryCode2);// opera��o
		JsonElement countryObj = gson.toJsonTree(countryInfo);
		if (countryInfo.getName() == null) {
			myObj.addProperty("success", false);
		} else {
			myObj.addProperty("success", true);
		}
		myObj.add("countryInfo", countryObj);
		out.println(myObj.toString());

		out.close();

	}

	// Get Country Information
	private Country getInfo(String countryCode) {

		Country country = new Country();
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement stmt = null;
		String sql = null;

		try {

			sql = "Select * from country where code = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, countryCode.trim());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				country.setCode(rs.getString("code").trim());
				country.setName(rs.getString("name").trim());
				country.setContinent(rs.getString("continet").trim());
				country.setRegion(rs.getString("region").trim());
				country.setLifeExpectancy(rs.getString("lifeExpetancy") == null ? new Double(
						0) : Double.parseDouble(rs.getString("lifeExpetancy")
						.trim()));
				country.setGnp(rs.getString("gnp") == null ? new Double(0)
						: Double.parseDouble(rs.getString("gnp").trim()));
			}

			rs.close();
			stmt.close();
			stmt = null;

			conn.close();
			conn = null;

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlex) {
					// ignore -- as we can't do anything about it here
				}

				stmt = null;
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException sqlex) {
					// ignore -- as we can't do anything about it here
				}

				conn = null;
			}
		}

		return country;

	}

}
