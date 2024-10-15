package estudo.spring.services.auth;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

import estudo.spring.domain.entities.auth.Usuario;
import estudo.spring.services.interfaces.ITokenService;

@Service
public class TokenService implements ITokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(Usuario usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                .withIssuer("Api Medico")
                .withSubject(usuario.getUser())
                .withExpiresAt(dataExpiracao())
                .sign(algorithm);

                return token;
        } catch (JWTCreationException exception){
            throw new RuntimeException("erro ao gerar token jwt", exception);
        }
    }

    public String getSubject(String tokenJWT){
        DecodedJWT decodedJWT;
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                // specify any specific claim validations
                .withIssuer("Api Medico")
                // reusable verifier instance
                .build();
                
            decodedJWT = verifier.verify(tokenJWT);
            System.err.println("DECODED");
            return decodedJWT.getSubject();
        } catch (JWTVerificationException exception){
            throw exception;
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
