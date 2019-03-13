package com.ciandt.treinamento.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comic implements Serializable {

	private static final long serialVersionUID = 3162213335531866869L;
	private Long id;
	private String title;
	private String description;
	private Integer pageCount;
	private Thumbnail thumbnail;
}
