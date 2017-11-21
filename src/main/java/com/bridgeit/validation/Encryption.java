package com.bridgeit.validation;


import java.security.MessageDigest;

import org.springframework.stereotype.Component;


@Component
public class Encryption {


	/**
	 * @param password
	 * @return for password in DB, we must not explicitly store it. so we use a MD5
	 *         password encryption technique.
	 */
	public String encryptPassword(String password) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			System.out.println(bytes);
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			System.out.println(sb);
			generatedPassword = sb.toString();
		} catch (Exception e) {
			System.out.println(e);
		}

		return generatedPassword;
	}
}
