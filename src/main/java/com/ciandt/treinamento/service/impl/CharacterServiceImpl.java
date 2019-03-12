package com.ciandt.treinamento.service.impl;

import java.util.List;

import com.ciandt.treinamento.constants.MarvelApiConstants;
import com.ciandt.treinamento.controller.entity.Personagem;
import com.ciandt.treinamento.dto.ResponseCharacterJson;
import com.ciandt.treinamento.entity.PersonagemEntity;
import com.ciandt.treinamento.service.CharacterService;
import com.ciandt.treinamento.util.ApiUtils;


public class CharacterServiceImpl implements CharacterService {
    

	@Override
	public Personagem searchAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personagem searchById(Long id) {
			
			String url = ApiUtils.buildUrl(MarvelApiConstants.PATH_CHARACTERS+"/"+id, 
				MarvelApiConstants.PRIVATE_KEY, 
				MarvelApiConstants.API_KEY_VALUE);
				Personagem person = (Personagem) ApiUtils.getObject(url, Personagem.class);		
		return person;
	}

	@Override
	public List<Personagem> searchByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
