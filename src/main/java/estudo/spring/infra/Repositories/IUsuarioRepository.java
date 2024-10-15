package estudo.spring.infra.Repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import estudo.spring.domain.entities.auth.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByUser(String user);
}
