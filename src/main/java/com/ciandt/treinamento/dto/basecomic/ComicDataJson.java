package com.ciandt.treinamento.dto.basecomic;

import java.io.Serializable;
import java.util.List;

import com.ciandt.treinamento.dto.Comic;
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
public class ComicDataJson implements Serializable {

	private static final long serialVersionUID = 310334370537975201L;
	private Integer offset;
	private Integer limit;
	private Integer total;
	private Integer count;
	private List<Comic> results;
}
