package br.unicamp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nome;
	String sobrenome;
	String e_mail;
	String titular;
	String matricula;
	String tipo;

	public Participante() {
	}

	public Participante(Long id, String nome, String sobrenome, String e_mail, String titular, String matricula,
			String tipo) {
		this.id = id;
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

}
