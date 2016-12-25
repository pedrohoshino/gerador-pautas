package br.unicamp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reuniao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String titulo;
	String descricao;
	String local;
	String data;
	String hora;
	String arquivo;

	public Reuniao(){

	}

	public Reuniao(Long id, String titulo, String descricao, String local, String data, String hora, String arquivo) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.local = local;
		this.data = data;
		this.hora = hora;
		this.arquivo = arquivo;
	}

	public String getArquivo() {
		return arquivo;
	}

	public String getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}
	public String getHora() {
		return hora;
	}

	public Long getId() {
		return id;
	}

	public String getLocal() {
		return local;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setArquivo(String arquivo){
		this.arquivo = arquivo;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



}
