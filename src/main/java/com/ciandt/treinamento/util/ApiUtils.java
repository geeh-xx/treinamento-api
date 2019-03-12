package com.ciandt.treinamento.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.web.client.RestTemplate;

import com.ciandt.treinamento.constants.MarvelApiConstants;

public class ApiUtils {

	private static final String EQUAL = "=";
	private static Long timeStamp;
	private static String hash;

	private ApiUtils() {
	}

	public static Object getObject(String url, Class<?> classJson) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(url, classJson);
	}

	/**
	 * Converte a string para um hash e retorna a string gerada a partir do hash.
	 * 
	 * @param parametro a ser utilizado.
	 * @return string gerada a partir do parametro.
	 */
	public static String generateHash(String parametro) {
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

	public static String buildUrl(String urlPath, Integer limit) {
		loadValues();
		return MarvelApiConstants.URL + urlPath + "?" + MarvelApiConstants.API_KEY + EQUAL + MarvelApiConstants.API_KEY_VALUE + "&"
				+ MarvelApiConstants.TS + EQUAL + timeStamp + "&" + MarvelApiConstants.HASH + EQUAL + hash
				+ "&" + MarvelApiConstants.LIMIT + EQUAL + limit;
	}

	private static void loadValues() {
		timeStamp = new Date().getTime();
		hash = ApiUtils.generateHash(timeStamp  + MarvelApiConstants.PRIVATE_KEY + MarvelApiConstants.API_KEY_VALUE);
	}
}
