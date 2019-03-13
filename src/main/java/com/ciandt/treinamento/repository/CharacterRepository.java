package com.ciandt.treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciandt.treinamento.entity.CharacterEntity;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {

	List<CharacterEntity> findByNome(String nome);
	
	List<CharacterEntity> findByNomeStartingWith(String nome);

}
