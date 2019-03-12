package com.ciandt.treinamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
//	@GetMapping("/characters/")
//	public ResponseEntity<Object> returnAllCharacters(@PathVariable Long id) {
//		CharacterService characters = new CharacterServiceImpl();
////		return (ResponseEntity<Object>) characters.characterList(id);
//		return null;
//TODO 	
//	}
	
	
//	@GetMapping(path = "/characters/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Personagem> getOneCharacterById(@PathVariable("id") Long id) {
//		Personagem personagem = service.searchById(id);
//		return ResponseEntity.ok(personagem);
//	}
	
	

	@GetMapping("/characters/{name}")
	public ResponseEntity<Object> returnCharactersByName(@PathVariable String name) {
//		return (ResponseEntity<Object>) characters.characterList(quantidade);
		return null;

	}

	@GetMapping(path = "/character/{id}")
	public ResponseEntity<Personagem> getOneCharacterById(@PathVariable Long id) {
		Personagem personagem = service.searchById(id);
		return ResponseEntity.ok(personagem);
	}
}
	