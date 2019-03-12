package com.ciandt.treinamento.dataprovider;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.treinamento.controller.entity.Personagem;
import com.ciandt.treinamento.controller.entity.Thumbnail;
import com.ciandt.treinamento.entity.PersonagemEntity;
import com.ciandt.treinamento.repository.PersonagemRepository;

@Component
public class PersonagemDataProvider {

	private PersonagemRepository personagemRepository;

	@Autowired
	public PersonagemDataProvider(PersonagemRepository personagemRepository) {
		this.personagemRepository = personagemRepository;
	}
	
	public void saveListaRestrita(List<Personagem> lista) {
		List<PersonagemEntity> listaConvertida = convertPersonagemtoEntityList(lista);
		personagemRepository.saveAll(listaConvertida);
	}

	public void savePersonagem(List<Personagem> list) {

		personagemRepository.saveAll(convertPersonagemtoEntityList(list));
	}

	/*
	 * Converte uma Lista de Personagens para uma lista de PersonagemEntity
	 */
	private List<PersonagemEntity> convertPersonagemtoEntityList(List<Personagem> list) {
		return list.stream().map(PersonagemDataProvider::convertPersonagemtoEntity).collect(Collectors.toList());
	}

	/*
	 * Converte uma Lista de PersonagemEntity para uma lista de Personagens
	 */
	private List<Personagem> convertPEntitytoPersonagemList(List<PersonagemEntity> list) {
		return list.stream().map(PersonagemDataProvider::convertPEntitytoPersonagem).collect(Collectors.toList());
	}

	/*
	 * Converte um PersonagemEntity para um Personagem
	 */
	private static PersonagemEntity convertPersonagemtoEntity(Personagem personagem) {

		return PersonagemEntity.builder().descricao(personagem.getDescricao())
				.identificador(personagem.getIdentificador()).nome(personagem.getNome())
				.imagem(personagem.getImagem().getPath()).build();
	}

	/*
	 * Converte um Personagem para um PersonagemEntity
	 */
	private static Personagem convertPEntitytoPersonagem(PersonagemEntity personagem) {

		return Personagem.builder().descricao(personagem.getDescricao()).identificador(personagem.getIdentificador())
				.nome(personagem.getNome()).imagem(new Thumbnail(personagem.getImagem(), "png")).build();
	}

	public List<Personagem> findByNameStartsWith(String nome) {

		List<PersonagemEntity> list = personagemRepository.findByNomeStartingWith(nome);

		return convertPEntitytoPersonagemList(list);

	}

}
