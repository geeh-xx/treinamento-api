package com.ciandt.treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ciandt.treinamento.entity.PersonagemEntity;

public interface PersonagemRepository extends JpaRepository<PersonagemEntity, Long> {

	List<PersonagemEntity> findByNomeStartingWith(String nome);

}
