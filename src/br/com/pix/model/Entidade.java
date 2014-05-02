package br.com.pix.model;

public class Entidade {
	private int id;
	private String nome;
	private String descricao;

	public void setId(int id){
		this.id = id;
		
	}
	public int getId(){
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
