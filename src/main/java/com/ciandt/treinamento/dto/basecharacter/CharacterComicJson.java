package com.ciandt.treinamento.dto.basecharacter;

import java.io.Serializable;
import java.util.List;

import com.ciandt.treinamento.dto.ResourceJson;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CharacterComicJson implements Serializable {

	private static final long serialVersionUID = 8873900324291645528L;
	private Integer available;
	private String collectionURI;
	private List<ResourceJson> items;
}
