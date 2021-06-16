package br.com.advinhacao.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	public Ranking( Jogador jogador, Long chutes, Double tempo) {
		
		this.jogador = jogador;
		this.chutes = chutes;
		this.tempo = tempo;
	}

	
	

}
