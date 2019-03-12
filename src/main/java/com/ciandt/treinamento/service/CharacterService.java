package com.ciandt.treinamento.service;

import java.util.List;

import com.ciandt.treinamento.controller.entity.Personagem;

public interface CharacterService {

	Personagem searchAll();
	
	Personagem searchById(Long id);
	
	List<Personagem> searchByName(String name);
	
}
