package br.unicamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reuniao_participantes")

public class ReuniaoParticipantes {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="tipo_participacao")
	private String tipoParticipacao;

	
	@ManyToOne(optional = true)
	//@Column(name="idparticipante")
    private Participante participante;
	
	@ManyToOne(optional = true)
	//@Column(name="idreuniao")
	private Reuniao reuniao;
	
	
	/*@ManyToMany(targetEntity=Reuniao.class)
	private Set<Reuniao> reuniaoSet;*/
	
	public ReuniaoParticipantes() {
	}

	public ReuniaoParticipantes(Long id, String tipoParticipacao, Participante participante, Reuniao reuniao) {
		this.id = id;
		this.participante = participante;
		this.reuniao = reuniao;
		this.tipoParticipacao = tipoParticipacao;
	}
		

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoParticipacao() {
		return tipoParticipacao;
	}
	
	public void setTipoParticipacao(String tipoParticipacao) {
		this.tipoParticipacao = tipoParticipacao;
	}

	public Participante getParticipante() {
		return participante;
	}

	public void setParticipante(Participante participante) {
		this.participante = participante;
	}

	public Reuniao getReuniao() {
		return reuniao;
	}

	public void setReuniao (Reuniao reuniao) {
		this.reuniao = reuniao;
	}


	

}
