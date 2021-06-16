package br.com.advinhacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;


@Entity
public class Ranking {
	
	@ApiModelProperty(value = "Codigo de ranking")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	 
	@ApiModelProperty(value = "Jogador")
	@ManyToOne
	private Jogador jogador;
	
	 @ApiModelProperty(value = "Chutes que o sistema dar")
	private Long chutes;
	 
	 @ApiModelProperty(value = "Tempo decorrido em segundos")
	private Double tempo; 

		public Ranking(Long id, Jogador jogador, Long chutes, Double tempo) {
			this.id = id;
			this.jogador = jogador;
			this.chutes = chutes;
			this.tempo = tempo;
		}
	 
	 
		public Ranking( Jogador jogador, Long chutes, Double tempo) {
			this.jogador = jogador;
			this.chutes = chutes;
			this.tempo = tempo;
		}
	
		public Ranking( ) {

		}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Long getChutes() {
		return chutes;
	}

	public void setChutes(Long chutes) {
		this.chutes = chutes;
	}

	public Double getTempo() {
		return tempo;
	}

	public void setTempo(Double tempo) {
		this.tempo = tempo;
	}


}
