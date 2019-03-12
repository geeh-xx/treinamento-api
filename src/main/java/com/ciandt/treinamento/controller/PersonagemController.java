package com.ciandt.treinamento.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ciandt.treinamento.entity.PersonagemEntity;
import com.ciandt.treinamento.service.CharacterService;

@RequestMapping("api/v1")
public class PersonagemController{
	
	private CharacterService service;
		
	@Autowired
	public PersonagemController(CharacterService service) {
		this.service = service;
	}

	@GetMapping("/characters/{id}")
	public ResponseEntity<PersonagemEntity> getOneCharacterById(@PathVariable Long id) {
		PersonagemEntity personagem = service.searchById(id);
		
		return null;
	}
}
