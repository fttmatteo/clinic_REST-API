package app.adapter.out.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import app.domain.model.auth.AuthCredentials;
import app.domain.model.auth.TokenResponse;
import app.domain.ports.AuthenticationPort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

/**
 * Adaptador que implementa el puerto {@link AuthenticationPort} utilizando
 * la biblioteca JJWT para generar y validar tokens JWT. Este adaptador
 * encapsula toda la lógica de firma y validación, permitiendo que la
 * lógica de dominio permanezca independiente de la tecnología utilizada.
 * 
 * ADVERTENCIA: La clave secreta se genera aleatoriamente en memoria en cada
 * inicio de la aplicación. Esto significa que:
 * - Todos los tokens JWT se invalidan al reiniciar el servidor
 * - No es posible tener múltiples instancias del servicio (sin balanceo de carga con sesión sticky)
 * 
 * Para producción, se recomienda externalizar la clave secreta a application.properties:
 * jwt.secret=${JWT_SECRET:your-base64-encoded-secret-key}
 * 
 * Generar clave segura: openssl rand -base64 64
 */
@Component
public class JwtAdapter implements AuthenticationPort {
    // TODO: Para producción, externalizar esta clave a configuración
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final long EXPIRATION_TIME = 30 * 60 * 1000; // 30 minutos

    @Override
    public TokenResponse authenticate(AuthCredentials credentials, String role) {
        String token = this.generateToken(credentials.getUsername(), role);
        TokenResponse response = new TokenResponse();
        response.setToken(token);
        return response;
    }

    @Override
    public boolean validateToken(String token) {
        try {
            this.getClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String extractUsername(String token) {
        Claims claims = this.getClaims(token);
        return claims.getSubject();
    }

    @Override
    public String extractRole(String token) {
        Claims claims = this.getClaims(token);
        return claims.get("role", String.class);
    }

    private String generateToken(String username, String role) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + EXPIRATION_TIME);

        String token = Jwts.builder()
            .setSubject(username)
            .claim("role", role)
            .setIssuedAt(now)
            .setExpiration(expiration)
            .signWith(SECRET_KEY)
            .compact();

        return token;
    }

    private Claims getClaims(String token) {
        Claims claims = Jwts.parserBuilder()
            .setSigningKey(SECRET_KEY)
            .build()
            .parseClaimsJws(token)
            .getBody();
        return claims;
    }
}