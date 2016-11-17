package br.unicamp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String nome;
	String cargo;
	String registro;
	
	public Usuario(){
	}
	
	public Usuario(Long id, String nome, String cargo, String registro){
		this.id =id;
		this.nome = nome;
		this.cargo = cargo;
		this.registro = registro;
	}

	public String getCargo() {
		return cargo;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRegistro() {
		return registro;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}

}
