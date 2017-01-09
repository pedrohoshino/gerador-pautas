package br.unicamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ata")
public class Ata {

	@Id
	@Column(name="idata")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idata;
	
	@ManyToOne
    @PrimaryKeyJoinColumn(name="idreuniao", referencedColumnName="idreuniao")
    private Reuniao idreuniao;
	
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="data")
	String data;
	
	@Column(name="texto")
	String texto;

	public Ata(){

	}

	public Ata(Long idAta, Reuniao idReuniao, String titulo, String descricao, String data, String texto) {
		this.idata = idAta;
		this.idreuniao = idReuniao;
		this.titulo = titulo;
		this.descricao = descricao;
		this.data = data;
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}

	public String getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getId() {
		return idata;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setId(Long id) {
		this.idata = id;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
