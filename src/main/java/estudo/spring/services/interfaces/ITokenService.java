package estudo.spring.services.interfaces;

import estudo.spring.domain.entities.auth.Usuario;

public interface ITokenService {
    public String gerarToken(Usuario usuario);
    public String getSubject(String tokenJWT);
}
