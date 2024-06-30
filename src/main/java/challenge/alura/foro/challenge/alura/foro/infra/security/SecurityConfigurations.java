package challenge.alura.foro.challenge.alura.foro.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {


//    ToDO cambiar la extension topics por login cuando se implemente la verificacion de acceso
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST,  "/topics").permitAll()
                        .requestMatchers( HttpMethod.GET, "/topics").permitAll()
                        .requestMatchers( HttpMethod.GET, "/topics/{id}").permitAll()
                        .requestMatchers( HttpMethod.PUT, "/topics/{id}").permitAll()
                        .requestMatchers( HttpMethod.DELETE, "/topics/{id}").permitAll()
                        .requestMatchers("/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
