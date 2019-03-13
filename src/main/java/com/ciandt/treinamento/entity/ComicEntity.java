package com.ciandt.treinamento.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="comic")
@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComicEntity implements Serializable {

	private static final long serialVersionUID = 4963512624240716418L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identificador;

	private String titulo;

	private String descricao;

	private Integer numeroPaginas;

	private String imagemCapa;

}
