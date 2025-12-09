package app.infrastructure.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuración de seguridad para la aplicación. Define los filtros de
 * autenticación y las reglas de autorización basadas en roles para cada
 * uno de los recursos expuestos por los controladores REST.
 * 
 * NOTA: CSRF está deshabilitado porque esta es una API REST stateless que
 * utiliza JWT para autenticación. No se utilizan cookies de sesión, por
 * lo que la protección CSRF no es aplicable.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // CSRF deshabilitado: API stateless con JWT (no usa cookies de sesión)
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/**").permitAll()
                .requestMatchers("/employees/**").hasRole("HUMAN_RESOURCES")
                .requestMatchers("/administrative/**").hasRole("PERSONAL_ADMINISTRATIVE")
                .requestMatchers("/doctor/**").hasRole("DOCTOR")
                .requestMatchers("/nurse/**").hasRole("NURSE")
                .requestMatchers("/support/**").hasRole("INFORMATION_SUPPORT")
                .anyRequest().authenticated()
            )
            .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
