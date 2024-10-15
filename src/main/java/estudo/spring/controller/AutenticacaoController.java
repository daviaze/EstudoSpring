package estudo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import estudo.spring.domain.dtos.LoginDTO;
import estudo.spring.services.interfaces.IAuthService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {

    @Autowired
    private IAuthService _authService;
    
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid LoginDTO dados){
        var token = this._authService.authenticate(dados);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid LoginDTO dados){
        this._authService.register(dados);
        return ResponseEntity.ok().build();
    }
}
