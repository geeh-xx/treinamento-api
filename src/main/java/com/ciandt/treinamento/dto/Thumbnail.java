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
public class Thumbnail implements Serializable {

	private static final long serialVersionUID = -4972429819295605931L;
	
	private String path;
	private String extension;

}
