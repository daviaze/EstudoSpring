package estudo.spring.services.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import estudo.spring.infra.Repositories.IUsuarioRepository;

@Service
public class UserDService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository _userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this._userRepository.findByUser(username);
    }
}
