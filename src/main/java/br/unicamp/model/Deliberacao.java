package br.unicamp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Deliberacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String titulo;
	String assunto;
	String data;
	String arquivo;

	public Deliberacao(){

	}

	public Deliberacao(Long id, String titulo, String assunto, String data, String arquivo) {
		this.id = id;
		this.titulo = titulo;
		this.assunto = assunto;
		this.data = data;
		this.arquivo = arquivo;
	}

	public String getArquivo() {
		return arquivo;
	}

	public String getAssunto() {
		return assunto;
	}

	public String getData() {
		return data;
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

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
