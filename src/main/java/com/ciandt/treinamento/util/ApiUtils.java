package com.ciandt.treinamento.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ciandt.treinamento.constants.MarvelApiConstants;

@Component
public class ApiUtils {

	private static final String EQUAL = "=";
	private static final Integer DEFAULT_SIZE = 20;
	private static Long timeStamp;
	private static String hash;

	public Object getObject(String url, Class<?> classJson) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, classJson);
	}

	/**
	 * Converte a string para um hash e retorna a string gerada a partir do hash.
	 * 
	 * @param parametro a ser utilizado.
	 * @return string gerada a partir do parametro.
	 */
	private String generateHash(String parametro) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		md.update(parametro.getBytes());
		byte[] hashGerado = md.digest();

		StringBuilder s = new StringBuilder();
		for (int i = 0; i < hashGerado.length; i++) {
			int parteAlta = ((hashGerado[i] >> 4) & 0xf) << 4;
			int parteBaixa = hashGerado[i] & 0xf;
			if (parteAlta == 0) {
				s.append('0');
			}
			s.append(Integer.toHexString(parteAlta | parteBaixa));
		}
		return s.toString();
	}

	public String buildUrl(String urlPath, Integer limit) {
		loadValues();
		
		if (limit == null) {
			limit = DEFAULT_SIZE;
		}
		
		return MarvelApiConstants.URL + urlPath + "?" + MarvelApiConstants.API_KEY + EQUAL + MarvelApiConstants.API_KEY_VALUE + "&"
				+ MarvelApiConstants.TS + EQUAL + timeStamp + "&" + MarvelApiConstants.HASH + EQUAL + hash
				+ "&" + MarvelApiConstants.LIMIT + EQUAL + limit;
	}
	
	//Aqui poderia ser um Map, mas deixei apenas assim para facilitar o entendimento.
	public String appendParameterToUrl(String url, String parameter, String value) {
		return url + "&" + parameter + EQUAL + value; 
	}

	private void loadValues() {
		timeStamp = new Date().getTime();
		hash = generateHash(timeStamp  + MarvelApiConstants.PRIVATE_KEY + MarvelApiConstants.API_KEY_VALUE);
	}
}
