package br.com.advinhacao.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.advinhacao.model.Ranking;
import br.com.advinhacao.service.RankingService;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/ranking")
public class RankingController {
	
	@Autowired
	RankingService rankingService;
	
	public RankingController( RankingService rankingService) {
		this.rankingService = rankingService;
	}
	
	@ApiOperation(value = "Retorna um usuario por nome")
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Ranking>>obterPorId(@PathVariable String nome){
		List<Ranking> ranking = rankingService.findByJogadorName(nome);
		return ResponseEntity.ok(ranking);		
	}
	
	@ApiOperation(value = "Obten todos os rankings ordenados como criterio de menores chutes")
	@GetMapping()
	public ResponseEntity<List<Ranking>> ObterTodos(){
		List<Ranking>devs = rankingService.findAll();
		return ResponseEntity.ok(devs);
	}
	
	
	@ApiOperation(value = "Salva um novo ranking")
	@PostMapping
	public ResponseEntity<Ranking> salvar(@RequestBody Ranking ranking){
		Ranking dev = rankingService.save(ranking);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dev.getId()).toUri();
		return ResponseEntity.created(uri).body(dev); 
	}
	
	
	
}