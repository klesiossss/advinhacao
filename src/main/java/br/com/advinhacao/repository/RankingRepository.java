package br.com.advinhacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.advinhacao.model.Ranking;

public interface RankingRepository extends JpaRepository<Ranking, Long> {
	List<Ranking> findByJogadorNomeIgnoreCase(String nome);

}
