package br.com.advinhacao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.advinhacao.model.Jogador;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
	Jogador findByNome(String nome);
}
