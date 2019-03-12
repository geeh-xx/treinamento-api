package com.ciandt.treinamento.controller;

import javax.xml.stream.events.Characters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.treinamento.service.impl.CharacterServiceImpl;



import com.ciandt.treinamento.controller.entity.Personagem;
import com.ciandt.treinamento.service.CharacterService;
import com.ciandt.treinamento.service.impl.CharacterServiceImpl;


@RestController
@RequestMapping("api/v1")
public class CharactersController {

	private CharacterServiceImpl service;

	@Autowired
	public CharactersController(CharacterServiceImpl service) {
		this.service = service;
	}

	@GetMapping("/characters/")
	public ResponseEntity<Object> returnAllCharacters(
			@RequestParam(name = "quantidade", required = false) Integer quantidade) {
//		if (quantidade < 20)
//			return (ResponseEntity<Object>) CharacterServiceImpl.returnAllCharacters(quantidade);
//		else
//			return (ResponseEntity<Object>) CharacterServiceImpl.returnAllCharacters(20);
		return null;
	}

	@GetMapping(path = "/characters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Personagem> getOneCharacterById(@PathVariable("id") Long id) {
		Personagem personagem = service.searchById(id);
		return ResponseEntity.ok(personagem);
	}

	@GetMapping("/characters/{name}")
	public ResponseEntity<Object> returnCharactersByName(@PathVariable String name) {

		return ResponseEntity.ok(service.searchByName(name));
	}

}
