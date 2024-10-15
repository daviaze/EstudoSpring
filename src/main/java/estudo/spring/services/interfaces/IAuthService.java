package estudo.spring.services.interfaces;

import estudo.spring.domain.dtos.LoginDTO;
import estudo.spring.domain.dtos.TokenDTO;

public interface IAuthService {
    public TokenDTO authenticate(LoginDTO login);
    public void register(LoginDTO login);
}
