package com.ciandt.treinamento.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ciandt.treinamento.controller.entity.Personagem;
import com.ciandt.treinamento.service.CharacterService;

@RequestMapping("api/v1")
public class PersonagemController{
	
	private CharacterService service;
		
	@Autowired
	public PersonagemController(CharacterService service) {
		this.service = service;
	}

	@GetMapping(path = "/characters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personagem> getOneCharacterById(@PathVariable("id") Long id) {
		Personagem personagem = service.searchById(id);
		return ResponseEntity.ok(personagem);
	}
}
