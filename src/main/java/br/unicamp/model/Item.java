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
@Table(name="item")
public class Item {

	@Id
	@Column(name="iditem")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	//@Column(name="categoria")
	//private Long categoria;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="situacao")
	private String situacao;
	
	@Column(name="ordem")
	private Integer ordem;
	
	@Column(name="dataDeliberacao")
	private String dataDeliberacao;
	
	@Column(name="assuntoDeliberacao")
	private String assuntoDeliberacao;
	
	@Column(name="arquivoDeliberacao")
	private Blob arquivoDeliberacao;
	
	@ManyToOne
    private Reuniao reuniao;
	
	@ManyToOne
    private Participante assinante;
	
	@ManyToOne
    private Categoria categoria;
	
	
	
	
	public Item() {
	}
	
	public Item(Long id, String titulo, String descricao, String situacao, Integer ordem) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.situacao = situacao;
		this.ordem = ordem;
	}
	public Item(Long id, String titulo, String descricao, String situacao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.situacao = situacao;
	}

	/*public Long getCategoria() {
		return categoria;
	}

	public void setCategoria(Long categoria) {
		this.categoria = categoria;
	}*/

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
	
	public Integer getOrdem() {
		return this.ordem;
	}

	public void setOrdem(Integer ordem) {
		this.ordem = ordem;
	}
	
	public String getDataDeliberacao() {
		return this.dataDeliberacao;
	}

	public void setDataDeliberacao(String data) {
		this.dataDeliberacao = data;
	}
	
	public String getAssuntoDeliberacao() {
		return this.assuntoDeliberacao;
	}

	public void setAssuntoDeliberacao(String assunto) {
		this.assuntoDeliberacao = assunto;
	}

	public Blob getArquivoDeliberacao() {
		return arquivoDeliberacao;
	}

	public void setArquivoDeliberacao(Blob arquivo) {
		this.arquivoDeliberacao = arquivo;
	}
	
	public Reuniao getReuniao(){
		return reuniao;
	}
	
	public void setReuniao(Reuniao reuniao){
		this.reuniao = reuniao;
	}
	
	public Participante getAssinanteDeliberacao(){
		return this.assinante;
	}
	
	public void setAssinanteDeliberacao(Participante participante){
		this.assinante = participante;
	}

	public Categoria getCategoria(){
		return categoria;
	}
	
	public void setCategoria(Categoria categoria){
		this.categoria = categoria;
	}

	
}
