package com.yahoo.random;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hashes {

	/**
	 *MD5 is not collision resistent crytographic one way hash fn (one where you cant get which string can create hash1) md5(string)=hash1
	 *A encryption algo could be used to get back original string from the hash
	 *MD5 and SHA hashes in raw form are binary, however their common representation is a hex-encoded string, which contains characters [a-fA-F0-9].
	 *Hence we usually base64.encode(md5(String)) base64 encode the md5 byte array. More so how to store byte array so use base64
	 *
	 *Password in DB should be hash(one way) + salt in DB now when input comes do hash+salt again and compare with DB. IF you store 
	 *encrypted val of passwd in db someone can get private key and get back your password
	 * @throws NoSuchAlgorithmException 
	 *
	 */
	public static void main(String[] args) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update("AUM".getBytes());
		byte[] b = md.digest();
		System.out.println(new String(b));
		
		try {
			//This is stream update like CRC32
			//LSG
			MessageDigest md1 = MessageDigest.getInstance("MD5");
			String salt = "LIGHT"+12344+"SABER";//12344 is sledid
			//This is function digest() is final update to digest else you can call md1.update multiple times as stream
			md1.digest(salt.getBytes("UTF-8")); 
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
