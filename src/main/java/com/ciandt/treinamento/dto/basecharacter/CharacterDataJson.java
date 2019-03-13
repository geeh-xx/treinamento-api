package com.ciandt.treinamento.dto.basecharacter;

import java.io.Serializable;
import java.util.List;

import com.ciandt.treinamento.dto.CharacterMarvel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class CharacterDataJson implements Serializable {

	private static final long serialVersionUID = 310334370537975201L;
	private Integer offset;
	private Integer limit;
	private Integer total;
	private Integer count;
	private List<CharacterMarvel> results;
}
