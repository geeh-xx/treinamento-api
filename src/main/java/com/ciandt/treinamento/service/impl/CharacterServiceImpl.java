package com.ciandt.treinamento.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ciandt.treinamento.constants.MarvelApiConstants;
import com.ciandt.treinamento.controller.entity.Personagem;
import com.ciandt.treinamento.dto.ResponseCharacterJson;
import com.ciandt.treinamento.service.CharacterService;
import com.ciandt.treinamento.util.ApiUtils;


@Component
public class CharacterServiceImpl implements CharacterService {

	public List<Personagem> returnAllCharacters(Integer limit) {
		String url = ApiUtils.buildUrl(MarvelApiConstants.PATH_CHARACTERS, MarvelApiConstants.PRIVATE_KEY,
				MarvelApiConstants.API_KEY_VALUE);
		ResponseCharacterJson personagens = (ResponseCharacterJson) ApiUtils.getObject(url,
				ResponseCharacterJson.class);
		List<Personagem> listaPersonagem = new ArrayList<>();
		personagens.getData().getResults().stream().map(p -> listaPersonagem.add(p));
		return listaPersonagem;

	}

	@Override
	public Personagem searchById(Long id) {
			
			String url = ApiUtils.buildUrl(MarvelApiConstants.PATH_CHARACTERS+"/"+id, 
				MarvelApiConstants.PRIVATE_KEY, 
				MarvelApiConstants.API_KEY_VALUE);
				ResponseCharacterJson personagens = (ResponseCharacterJson) ApiUtils.getObject(url,
					ResponseCharacterJson.class);
				Personagem person = personagens.getData().getResults().get(0);
				
				
		return person;
	}

	@Override
	public Personagem searchByName(String nome) {
		// TODO Auto-generated method stub
		return null;
	}
	



	
	
}
