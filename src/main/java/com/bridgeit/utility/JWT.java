package com.bridgeit.utility;

import org.springframework.stereotype.Component;

import com.bridgeit.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JWT {

	final String key = "qazxswedc";

	public String jwtGenerator(User user) {

		String jwToken = Jwts.builder()
				.setSubject("Registration")
				.setId(user.getEmail())
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();

		return jwToken;
	}

	public String jwtVerify(String jwToken) {
		String status;
		try {
			Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwToken).getBody();
			status = claims.getId();
		} catch (SignatureException e) {
			status = null;
		}
		return status;
	}

}
