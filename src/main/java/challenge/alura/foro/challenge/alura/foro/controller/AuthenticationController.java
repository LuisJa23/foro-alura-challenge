package challenge.alura.foro.challenge.alura.foro.controller;

import challenge.alura.foro.challenge.alura.foro.domain.user.dto.UserAuthenticationData;
import challenge.alura.foro.challenge.alura.foro.domain.user.model.User;
import challenge.alura.foro.challenge.alura.foro.infra.security.dto.JWTTokenData;
import challenge.alura.foro.challenge.alura.foro.infra.security.service.TokenService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Authentication", description = "obtiene el token para el usuario asignado que da acceso al resto de endipont")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity authenticateUser(@RequestBody @Valid UserAuthenticationData userAuthenticationData) {

        Authentication authToken = new UsernamePasswordAuthenticationToken(userAuthenticationData.email(),
                userAuthenticationData.password());

        var authenticatedUser = authenticationManager.authenticate(authToken);

        var JWTtoken = tokenService.generateToken((User) authenticatedUser.getPrincipal());

        return ResponseEntity.ok(new JWTTokenData(JWTtoken));
    }

}
