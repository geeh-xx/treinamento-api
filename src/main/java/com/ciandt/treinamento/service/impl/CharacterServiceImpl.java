package com.ciandt.treinamento.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.treinamento.constants.MarvelApiConstants;
import com.ciandt.treinamento.controller.entity.Personagem;
import com.ciandt.treinamento.dataprovider.PersonagemDataProvider;
import com.ciandt.treinamento.dto.ResponseCharacterJson;
import com.ciandt.treinamento.service.CharacterService;
import com.ciandt.treinamento.util.ApiUtils;

@Component
public class CharacterServiceImpl implements CharacterService {


	private PersonagemDataProvider personagemDataProvider;

	@Autowired
	public CharacterServiceImpl(PersonagemDataProvider personagemDataProvider) {
		this.personagemDataProvider = personagemDataProvider;
	}

	public List<Personagem> returnAllCharacters(Integer limit) {
		 List<Personagem> personagens = findAll();
		 List<Personagem> listaRestrita = new ArrayList<>();

		for (int i = 0; i < personagens.size(); i++) {
			if(i <= limit) {
				listaRestrita.add(personagens.get(i));
			}
		} 
		return listaRestrita;
	}

	@Override
	public Personagem searchById(Long id) {

		String url = ApiUtils.buildUrl(MarvelApiConstants.PATH_CHARACTERS + "/" + id, MarvelApiConstants.PRIVATE_KEY,
				MarvelApiConstants.API_KEY_VALUE);
				ResponseCharacterJson personagens = (ResponseCharacterJson) ApiUtils.getObject(url,
					ResponseCharacterJson.class);
				Personagem person = personagens.getData().getResults().get(0);
				
		return person;
	}

	@Override
	public List<Personagem> searchByName(String nome) {

		findAll();

		return personagemDataProvider.findByNameStartsWith(nome);
	}

	public List<Personagem> findAll() {

		String url = ApiUtils.buildUrl(MarvelApiConstants.PATH_CHARACTERS, MarvelApiConstants.PRIVATE_KEY,
				MarvelApiConstants.API_KEY_VALUE);
		ResponseCharacterJson personagens = (ResponseCharacterJson) ApiUtils.getObject(url,
				ResponseCharacterJson.class);
		List<Personagem> listaPersonagem = new ArrayList<>();
		personagens.getData().getResults().forEach(p -> {
			listaPersonagem.add(p);
		});

		personagemDataProvider.savePersonagem(listaPersonagem);

		return listaPersonagem;
	}

}
