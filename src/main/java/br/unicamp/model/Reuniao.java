package br.unicamp.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	String textoReuniao;

	@ManyToMany(targetEntity=Participante.class)
	private Set<Participante> participantes;

	public Reuniao(){

	}

	public Reuniao(Long id, String titulo, String descricao, String local, String data, String hora, String textoReuniao) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.local = local;
		this.data = data;
		this.hora = hora;
		this.textoReuniao = textoReuniao;
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
	public Set<Participante> getParticipantes() {
		return participantes;
	}

	public String getTextoReuniao() {
		return textoReuniao;
	}

	public String getTitulo() {
		return titulo;
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

	public void setParticipantes(Set<Participante> participantes) {
		this.participantes = participantes;
	}

	public void setTextoReuniao(String textoReuniao){
		this.textoReuniao = textoReuniao;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



}
