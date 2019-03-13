package com.ciandt.treinamento.dto.basecomic;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComicResponseJson implements Serializable {

	private static final long serialVersionUID = 5681395932342062965L;
	
	private Long code;
	private String status;
	private ComicDataJson data;
}
