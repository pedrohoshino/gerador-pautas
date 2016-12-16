package br.unicamp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pauta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String titulo;
	String descricao;
	String arquivo;
	
	public Pauta(){
		
	}
	
	public Pauta(Long id, String titulo, String descricao, String arquivo) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.arquivo = arquivo;
	}

	public String getArquivo() {
		return arquivo;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	

}
