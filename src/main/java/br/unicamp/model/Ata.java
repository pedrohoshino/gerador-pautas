package br.unicamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ata")
public class Ata {

	@Id
	@Column(name="idata")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idata;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="data")
	private String data;
	
	@Column(name="texto")
	//private Clob texto;
	private String texto;
	
	@ManyToOne
    private Reuniao reuniao;
	
	

	public Ata(){

	}

	public Ata(Long idAta, String titulo, String descricao, String data, String texto) {
		this.idata = idAta;
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
	
	public Reuniao getReuniao(){
		return reuniao;
	}
	
	public void setReuniao(Reuniao reuniao){
		this.reuniao = reuniao;
	}
}
