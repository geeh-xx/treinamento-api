package com.ciandt.treinamento.service;

import java.util.List;

import com.ciandt.treinamento.controller.entity.Personagem;
import com.ciandt.treinamento.entity.PersonagemEntity;

public interface CharacterService {

	public List<Personagem> returnAllCharacters(Integer limit);

	public PersonagemEntity search();

	public List<Personagem> searchByName(String nome);
}
