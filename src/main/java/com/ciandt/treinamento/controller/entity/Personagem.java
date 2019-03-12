package com.ciandt.treinamento.controller.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Personagem {
	

	@JsonProperty("name")
	private String nome;

	@JsonProperty("id")
	private Long identificador;

	@JsonProperty("description")
	private String descricao;

	@JsonProperty("thumbnail")
	private Thumbnail imagem;

	// @JsonProperty("comics")
	// private List<Revista> revistas;

}
