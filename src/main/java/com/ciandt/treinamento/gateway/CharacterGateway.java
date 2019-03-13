package com.ciandt.treinamento.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.treinamento.entity.CharacterEntity;
import com.ciandt.treinamento.repository.CharacterRepository;

@Component
public class CharacterGateway {

	@Autowired
	private CharacterRepository repository;
	
	public List<CharacterEntity> findAll() {
		return repository.findAll();
	}
	
	public List<CharacterEntity> findByName(String name) {
		return repository.findByNome(name);
	}
	
	public Optional<CharacterEntity> findbyId(Long id) {
		return repository.findById(id);
	}
	
	public CharacterEntity save(CharacterEntity characterEntity) {
		return repository.saveAndFlush(characterEntity);
	}
	
	public List<CharacterEntity> saveAll(List<CharacterEntity> characters) {
		return repository.saveAll(characters);
	}
	
	public void delete(CharacterEntity characterEntity) {
		repository.delete(characterEntity);
	}
	
	public void delebeById(Long id) {
		repository.deleteById(id);
	}
}
