package com.ciandt.treinamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ciandt.treinamento.entity.ComicEntity;

@Repository
public interface ComicRepository extends JpaRepository<ComicEntity, Long> {

	List<ComicEntity> findByDescricao(String descricao);
}
