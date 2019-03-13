package com.ciandt.treinamento.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResourceJson implements Serializable {

	private static final long serialVersionUID = -8669585804066600431L;
	private String resourceURI;
	private String name;
}
