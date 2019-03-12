package com.ciandt.treinamento.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ciandt.treinamento.constants.MarvelApiConstants;
import com.ciandt.treinamento.dto.ResponseCharacterJson;
import com.ciandt.treinamento.util.ApiUtils;

@RestController
@RequestMapping("api/v1")
public class UserController {

	@GetMapping(path = "/marvel", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Object> getString() {
		String url = ApiUtils.buildUrl(MarvelApiConstants.PATH_CHARACTERS, MarvelApiConstants.DEFAULT_LIMIT);

		Object person = ApiUtils.getObject(url, ResponseCharacterJson.class);
		return ResponseEntity.ok(person);
	}

}
