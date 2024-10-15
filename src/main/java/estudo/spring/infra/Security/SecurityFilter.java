package estudo.spring.infra.Security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import estudo.spring.infra.Repositories.IUsuarioRepository;
import estudo.spring.services.interfaces.ITokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Filter irá interceptar a requisição como um middleware
@Component
public class SecurityFilter extends OncePerRequestFilter{

    @Autowired
    private ITokenService _tokenService;

    @Autowired
    private IUsuarioRepository _usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        
        var tokenJWT = recuperarToken(request);

        //Valida e retorna subject
        if(tokenJWT != null){
            var subject = this._tokenService.getSubject(tokenJWT);
            var usuario = this._usuarioRepository.findByUser(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        //Chama o próximo filtro, se não tiver encerra os filtros
        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        
        if(authorizationHeader != null){
            return authorizationHeader.replace("Bearer", "").replace(" ", "");
        }

        return null;
    }
    
}
