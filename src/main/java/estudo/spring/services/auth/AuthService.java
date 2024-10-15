package estudo.spring.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import estudo.spring.domain.dtos.LoginDTO;
import estudo.spring.domain.dtos.TokenDTO;
import estudo.spring.domain.entities.auth.Usuario;
import estudo.spring.infra.Repositories.IUsuarioRepository;
import estudo.spring.services.interfaces.IAuthService;
import estudo.spring.services.interfaces.ITokenService;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private AuthenticationManager _manager;

    @Autowired
    private ITokenService _tokenService;

    @Autowired
    private IUsuarioRepository _userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenDTO authenticate(LoginDTO login){
        UsernamePasswordAuthenticationToken authObject = new UsernamePasswordAuthenticationToken(login.user(),
         login.senha());
        var authentication = this._manager.authenticate(authObject);

        String tokenJWT = this._tokenService.gerarToken((Usuario) authentication.getPrincipal());

        return new TokenDTO(tokenJWT);
    }

    public void register(LoginDTO login){
        this._userRepository.save(new Usuario(login.user(), this.passwordEncoder.encode(login.senha())));
    }
}
