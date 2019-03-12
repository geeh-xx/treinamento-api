package com.ciandt.treinamento.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ciandt.treinamento.constants.MarvelApiConstants;
import com.ciandt.treinamento.controller.entity.Personagem;
import com.ciandt.treinamento.dto.ResponseCharacterJson;
import com.ciandt.treinamento.entity.PersonagemEntity;
import com.ciandt.treinamento.service.CharacterService;
import com.ciandt.treinamento.util.ApiUtils;

public class CharacterServiceImpl implements CharacterService {

	public  List<Personagem> returnAllCharacters(Integer limit) {
		String url = ApiUtils.buildUrl(MarvelApiConstants.PATH_CHARACTERS, MarvelApiConstants.PRIVATE_KEY,
				MarvelApiConstants.API_KEY_VALUE);
		ResponseCharacterJson personagens = (ResponseCharacterJson) ApiUtils.getObject(url,
				ResponseCharacterJson.class);
		List<Personagem> listaPersonagem = new ArrayList<>();
		personagens.getData().getResults().stream().map(p -> listaPersonagem.add(p));
		return listaPersonagem;

	}

	@Override
	public PersonagemEntity search() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personagem searchByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
}
