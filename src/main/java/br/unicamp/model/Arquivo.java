package br.unicamp.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="arquivo")
public class Arquivo {

	@Id
	@Column(name="idarquivo")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="tipo")
	private String tipo;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="arquivo")
	private Blob arquivo;

	@ManyToOne
    private Item item;
	
	
	public Arquivo(){

	}

	public Arquivo(Long id, String nome, String titulo, String tipo, Blob arquivo) {
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
		this.nome = nome;
		this.tipo = tipo;
		this.arquivo = arquivo;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Blob getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(Blob arquivo) {
		this.arquivo = arquivo;
	}

	public Item getItem(){
		return item;
	}
	
	public void setItem(Item item){
		this.item = item;
	}

}
