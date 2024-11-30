package banquemisr.challenge05.application.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;

@Service
public class JwtService {

    private static final String secretKey = "34213c6c3a44c2ebb046e3ce957a061aca7bcc2466e48bd2b535cf5fa7f5cb58";


    public String extractUserEmail(String token) {
        return null;
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private Key getSignInKey() {
        byte[] apiKeySecretBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(apiKeySecretBytes);
    }
}
