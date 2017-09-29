package br.com.eco.sac.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ApplicationUtils {
	
	public static String criptografarSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		byte messageDigest [] = MessageDigest.getInstance("SHA-256").digest(senha.getBytes("UTF-8"));
		
		StringBuilder hexString = new StringBuilder();
		
		for(byte b: messageDigest){
			hexString.append(String.format("%02X", 0xFF & b));
		}
		
		return hexString.toString();
		
	}
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		System.out.println(criptografarSenha("adminfaesf"));
	}
}
