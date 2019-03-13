package com.ciandt.treinamento.dto;

import java.io.Serializable;

import com.ciandt.treinamento.dto.basecharacter.CharacterComicJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CharacterMarvel implements Serializable {
	

	private static final long serialVersionUID = 3951297248039410497L;
	private String name;
	private Long id;
	private String description;
	private Thumbnail thumbnail;
	private CharacterComicJson comics;
	
}
