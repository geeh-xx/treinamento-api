package com.ciandt.treinamento.gateway;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ciandt.treinamento.entity.ComicEntity;
import com.ciandt.treinamento.repository.ComicRepository;

@Component
public class ComicGateway {
	@Autowired
	private ComicRepository repository;
	
	public List<ComicEntity> findAll() {
		return repository.findAll();
	}
	
	public List<ComicEntity> findByDescription(String description) {
		return repository.findByDescricao(description);
	}
	
	public Optional<ComicEntity> findbyId(Long id) {
		return repository.findById(id);
	}
	
	public ComicEntity save(ComicEntity comicEntity) {
		return repository.saveAndFlush(comicEntity);
	}
	
	public List<ComicEntity> saveAll(List<ComicEntity> comics) {
		return repository.saveAll(comics);
	}
	
	public void delete(ComicEntity comicEntity) {
		repository.delete(comicEntity);
	}
	
	public void delebeById(Long id) {
		repository.deleteById(id);
	}
}
