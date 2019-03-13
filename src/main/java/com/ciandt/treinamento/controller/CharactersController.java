package com.ciandt.treinamento.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.treinamento.constants.MarvelApiConstants;
import com.ciandt.treinamento.dto.CharacterMarvel;
import com.ciandt.treinamento.dto.basecharacter.CharacterComicJson;
import com.ciandt.treinamento.dto.basecharacter.CharacterResponseJson;
import com.ciandt.treinamento.entity.CharacterEntity;
import com.ciandt.treinamento.gateway.CharacterGateway;
import com.ciandt.treinamento.util.ApiUtils;

@RestController
@RequestMapping("api/v1/characters")
public class CharactersController {
	
	@Autowired
	private ApiUtils apiUtils;

	@Autowired
	private CharacterGateway gateway;
	
	/**
	 * Exemplo de chamada -> http://localhost:8082/treinamento/api/v1/characters/
	 * @return
	 */
	@GetMapping("/")
	public List<CharacterMarvel> getAllCharacters(@RequestParam(name = "limit", required = false) Integer limit) {
		String url = apiUtils.buildUrl(MarvelApiConstants.CHARACTERS, limit);
		CharacterResponseJson characters =  (CharacterResponseJson) apiUtils.getObject(url, CharacterResponseJson.class);
		
		if (characters != null && characters.getData() != null && characters.getData().getResults() != null) {			
			gateway.saveAll(characters.getData().getResults().stream()
					.map(character -> {
						CharacterEntity entity = CharacterEntity.builder()
								.descricao(character.getDescription())
								.nome(character.getName())
								.imagem(character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension())
								.build();
						return entity;
					}).collect(Collectors.toList()));
			return characters.getData().getResults();
		}
		
		return null;
	}

	/**
	 * Exemplo de chamada -> http://localhost:8082/treinamento/api/v1/characters/iro
	 * @param name
	 * @return
	 */
	@GetMapping("/{name}")
	public List<CharacterMarvel> getCharactersByName(@PathVariable String name) {
		String url = apiUtils.buildUrl(MarvelApiConstants.CHARACTERS, null);
		url = apiUtils.appendParameterToUrl(url, MarvelApiConstants.NAME_STARTS_WITH, name);
		CharacterResponseJson characters = (CharacterResponseJson) apiUtils.getObject(url, CharacterResponseJson.class);
		
		if (characters != null && characters.getData() != null && characters.getData().getResults() != null) {
			return characters.getData().getResults();
		}
		else {
			return null;
		}
	}
	
	/**
	 *  Exemplo de chamada -> http://localhost:8082/treinamento/api/v1/characters/hulk/comics
	 * @param name
	 * @return
	 */
	@GetMapping("/{name}/comics")
	public CharacterComicJson getComicsByCharacterName(@PathVariable String name) {
		String url = apiUtils.buildUrl(MarvelApiConstants.CHARACTERS, null);
		url = apiUtils.appendParameterToUrl(url, MarvelApiConstants.NAME_STARTS_WITH, name);
		CharacterResponseJson characters = (CharacterResponseJson) apiUtils.getObject(url, CharacterResponseJson.class);
		
		if (characters != null && characters.getData() != null && characters.getData().getResults() != null) {
			return characters.getData().getResults().get(0).getComics();
		}
		else {
			return null;
		}
	}
}
