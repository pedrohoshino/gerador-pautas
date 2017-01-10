package br.unicamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="participante")
public class Participante {

	@Id
	@Column(name="idparticipante")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
    @PrimaryKeyJoinColumn(name="idusuario", referencedColumnName="idusuario")
    private Usuario idusuario;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="sobrenome")
	private String sobrenome;
	
	@Column(name="e_mail")
	private String e_mail;
	
	@Column(name="titular")
	private String titular;
	
	@Column(name="matricula")
	private String matricula;
	
	@Column(name="tipo")
	private String tipo;

	public Participante() {
	}

	public Participante(Long idparticipante, String nome, String sobrenome, String e_mail, String titular, String matricula,
			String tipo, Usuario idusuario) {
		this.id = idparticipante;
		this.idusuario = idusuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.e_mail = e_mail;
		this.titular = titular;
		this.matricula = matricula;
		this.tipo = tipo;
	}
	
	public Participante(Long idparticipante, String nome, String sobrenome, String e_mail, String titular, String matricula,
			String tipo) {
		this.id = idparticipante;
		this.idusuario = null;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.e_mail = e_mail;
		this.titular = titular;
		this.matricula = matricula;
		this.tipo = tipo;
	}
	
	

	public String getE_mail() {
		return e_mail;
	}

	public Long getId() {
		return id;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getTipo() {
		return tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}
	
	public Usuario getIdUsuario() {
		return this.idusuario;
	}


	public void setIdUsuario(Usuario idusuario) {
		this.idusuario = idusuario;
	}
	

}
