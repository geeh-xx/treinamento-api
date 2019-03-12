package com.ciandt.treinamento.service;

import java.util.List;

import com.ciandt.treinamento.controller.entity.Personagem;


public interface CharacterService {

	List<Personagem> returnAllCharacters(Integer limit);

	Personagem searchByName(String nome);
	
	Personagem searchById(Long id);
}
