package br.unicamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@Column(name="idusuario")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="login")
	private String login;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="tipo")
	private String tipo;
	
	public Usuario(){
	}
	
	public Usuario(Long id, String login, String senha, String tipo){
		this.id =id;
		this.login = login;
		this.senha = senha;
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public Long getId() {
		return this.id;
	}

	public String getLogin() {
		return this.login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSennha(String senha) {
		this.senha = senha;
	}

}
