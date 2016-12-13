package br.unicamp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String titulo;
	String descricao;
	String situacao;

	public Item() {
	}

	public Item(Long id, String titulo, String descricao, String situacao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.situacao = situacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getId() {
		return id;
	}

	public String getSituacao() {
		return situacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
