package com.ciandt.treinamento.controller;

import javax.xml.stream.events.Characters;

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

	@GetMapping("/characters/")
	public ResponseEntity<Object> returnAllCharacters(
			@RequestParam(name = "quantidade", required = false) Integer quantidade) {
//		if (quantidade < 20)
//			return (ResponseEntity<Object>) CharacterServiceImpl.returnAllCharacters(quantidade);
//		else
//			return (ResponseEntity<Object>) CharacterServiceImpl.returnAllCharacters(20);
		return null;

	}

	@GetMapping("/characters/{name}")
	public ResponseEntity<Object> returnCharactersByName(@PathVariable String name) {
//		return (ResponseEntity<Object>) characters.characterList(quantidade);
		return null;

	}

}
