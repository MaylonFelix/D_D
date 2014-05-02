package br.com.pix.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.pix.model.Entidade;

public class EntidadeDAO {

	private Connection connection;

	public EntidadeDAO(Connection connection) {
		this.connection = connection;
	}
	
	

	public void adiciona(Entidade entidade) {
		String sql = "insert into entidade " + "(nome,descricao) values (?,?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, entidade.getNome());
			stmt.setString(2, entidade.getDescricao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public List<Entidade> getLista() {
		String sql = "select * from entidade";
		List<Entidade> entidades = new ArrayList<Entidade>();
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Entidade
				Entidade entidade = new Entidade();
				entidade.setId(rs.getInt(1));
				entidade.setNome(rs.getString("nome"));
				entidade.setDescricao(rs.getString("descricao"));

				// adicionando o objeto � lista
				entidades.add(entidade);
			}
			rs.close();
			stmt.close();
			return entidades;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void exclui(Entidade entidade) {
		String sql = "delete from entidade where id = (?)";
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, entidade.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		
		}
	}
}
