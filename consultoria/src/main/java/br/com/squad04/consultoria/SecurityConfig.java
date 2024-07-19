package br.com.squad04.consultoria;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .csrf(Customizer.withDefaults()) // Atualização para a nova forma de configurar o CSRF
                .cors(Customizer.withDefaults()); // Atualização para a nova forma de configurar o CORS

        return http.build();
    }

}
