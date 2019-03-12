package com.ciandt.treinamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
			@RequestParam(name = "quantidade", required = false) Long quantidade) {
//		return (ResponseEntity<Object>) characters.characterList(quantidade);
		return null;

	}

	@GetMapping("/characters/{name}")
	public ResponseEntity<Object> returnCharactersByName(@PathVariable String name) {

		if (name.length() < 3) {
			return new ResponseEntity<Object>("São necessários no mínimo 3 caracteres", HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(service.searchByName(name));
	}

}
