package br.unicamp.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	
	public Usuario(Long id, String login, String senha, String tipo) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		this.id =id;
		this.login = login;
		this.tipo = tipo;
		

	/*	MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		this.senha = hexString.toString();
		*/
		
		this.senha = codificaSenha(senha);
		
	}
	
	private String codificaSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		return hexString.toString();
		
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

	public void setSennha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.senha = codificaSenha(senha);
	}
	
	
	/*
	 * Se a senha entrada por parâmatro for igual a senha do banco, retorna 0
	 * Caso sejam diferentes, retorna -1
	 * 	 */
	public Integer comparaSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String senhaBanco, temporaria;
		
		senhaBanco = getSenha();
		temporaria = codificaSenha(senha);
		
		
		if (senhaBanco.equals(temporaria))
			return 0;
		else
			return (-1);
	}
	
	
	

}
