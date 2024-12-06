package edu.pnu.util;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTUtile {
	private static final long ACCESS_TOKEN_MSEC = 100 * (60 * 1000);  	// 100분
	private static final String JWT_KEY = "edu.pnu.jwtkey";
	private static final String claimName = "username";
	private static final String prefix = "Bearer";
	
	private static String getJWTSource(String token) {
		if(token.startsWith(prefix)) return token.replace(prefix, "");
		return token;
	}
	
	public static String getJWT(String username) {
		String src = JWT.create()
						.withClaim(claimName, username)
						.withExpiresAt(new Date(System.currentTimeMillis()+ACCESS_TOKEN_MSEC))
						.sign(Algorithm.HMAC256(JWT_KEY));
		return prefix + src;
	}
	
	//토큰에 담긴 정보 중 key가 "username"인 데이터 가져오기
	public static String getClaim(String token) {
		String tok = getJWTSource(token);
		return JWT.require(Algorithm.HMAC256(JWT_KEY)).build().verify(tok).getClaim(claimName).asString();
	}
	
	//유효기간 만료 여부
	public static boolean isExpired(String token) {
		String tok = getJWTSource(token);
		return JWT.require(Algorithm.HMAC256(JWT_KEY)).build().verify(tok).getExpiresAt().before(new Date());
	}
}
