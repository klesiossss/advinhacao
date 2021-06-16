package br.com.advinhacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Jogador {
	

	@ApiModelProperty(value = "Código do jogador")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ApiModelProperty(value = "Nome do jogador")
	private String nome;
	
	
	
	public Jogador(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	public Jogador() {
	}

	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
	
}
