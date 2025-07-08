package thirdpartyservices.sercurity;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;

public class JwtUtils {

	private static final Logger logger = Logger.getLogger(JwtUtils.class);

	private static String SECRET_KEY = "JWT#SECRET_KEY@1";

	private static int jwtExpirationMs = 1000 * 60;

	public static String createJWT() {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setIssuedAt(new Date(nowMillis))
				.setExpiration(new Date(nowMillis + jwtExpirationMs)).setSubject("CGHS").setIssuer("CGHS")
				.signWith(signatureAlgorithm, signingKey);

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public String getUserNameFromJwtToken(String authToken) {
		return Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parseClaimsJws(authToken)
				.getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		// This line will throw an exception if it is not a signed JWS (as expected)
		try {
			Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY)).parse(authToken);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e);
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e);
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e);
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e);
		}

		return false;
	}

}
