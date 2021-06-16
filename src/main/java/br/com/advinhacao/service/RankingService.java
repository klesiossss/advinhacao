package br.com.advinhacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.advinhacao.model.Ranking;
import br.com.advinhacao.model.Jogador;
import br.com.advinhacao.repository.JogadorRepository;
import br.com.advinhacao.repository.RankingRepository;

@Service
public class RankingService {

	@Autowired
	RankingRepository rankingRepo;
	@Autowired
	JogadorRepository jogadorRepo;
	
	
	
	public List<Ranking> findByJogadorName(String nome){
		return rankingRepo.findByJogadorNomeIgnoreCase(nome);
	}
	
	public List<Ranking> findAll(){
		//return rankingRepo.findAll(PageRequest.of(0,10,Sort.by(Sort.Direction.ASC, "chutes")));
		return rankingRepo.findAll(Sort.by(Sort.Direction.ASC, "chutes"));
	}
	
	
	public Ranking save(Ranking ranking) {
		var jogador = jogadorRepo.findByNome(ranking.getJogador().getNome());
		if(jogador != null) {
		ranking.setJogador(jogador);
		}
		else {
			  var js =jogadorRepo.save(ranking.getJogador());
			  ranking.setJogador(js);
		}
		return rankingRepo.save(ranking);		
	}
	
}
