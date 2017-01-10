package br.unicamp.model;

import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reuniao")

public class Reuniao {

	@Id
	@Column(name="idreuniao")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="data") 
	private String data;
	
	@Column(name="hora")
	private String hora;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="local")
	private String local;
	
	@Column(name="descricao")
	private String descricao;

	@Column(name="textoReuniao")
	private String textoReuniao;

	public Reuniao(){

	}

	public Reuniao(Long id, String titulo, String descricao, String local, String data, String hora, String textoReuniao) {
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.titulo = titulo;
		this.local = local;
		this.descricao = descricao;
		this.textoReuniao = textoReuniao;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getData() {
		return data;
	}

	public String getHora() {
		return hora;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getLocal() {
		return local;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public String getTextoReuniao() {
		return textoReuniao;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public void setTextoReuniao(String textoReuniao) {
		this.textoReuniao = textoReuniao;
	}

}
