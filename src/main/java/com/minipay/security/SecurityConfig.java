package com.minipay.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.context.annotation.Bean;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers(
                    "/",
                    "/index.html",
                    "/index2.html",
                    "/favicon.ico",
                    "/manifest.json",
                    "/static/**"  // 🔓 Allow access to static JS/CSS
                ).permitAll()
                .anyRequest().authenticated()
            .and()
            .formLogin(); // or .httpBasic() depending on your app

        return http.build();
    }
}
