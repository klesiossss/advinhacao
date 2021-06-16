package br.com.advinhacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.advinhacao.model.Jogador;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
	Jogador findByNome(String nome);
}
