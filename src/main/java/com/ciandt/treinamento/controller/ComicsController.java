package com.ciandt.treinamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.treinamento.constants.MarvelApiConstants;
import com.ciandt.treinamento.dto.Comic;
import com.ciandt.treinamento.dto.basecomic.ComicResponseJson;
import com.ciandt.treinamento.util.ApiUtils;

@RestController
@RequestMapping("api/v1")
public class ComicsController {

	@Autowired
	private ApiUtils apiUtils;

	@GetMapping("/comics")
	public List<Comic> getAllCharacters(@RequestParam(name = "limit", required = false) Integer limit) {
		String url = apiUtils.buildUrl(MarvelApiConstants.COMICS, limit);
		ComicResponseJson comics =  (ComicResponseJson) apiUtils.getObject(url, ComicResponseJson.class);
		
		if (comics != null && comics.getData() != null && comics.getData().getResults() != null) {			
			return comics.getData().getResults();
		}
		
		return null;
	}
}
