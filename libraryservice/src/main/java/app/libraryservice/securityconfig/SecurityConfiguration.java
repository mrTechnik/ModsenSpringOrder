package app.libraryservice.securityconfig;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf
                .disable())
                .authorizeHttpRequests((requests -> requests
                        .anyRequest().permitAll()                       
                        ));
        http.cors(cors -> cors.configurationSource(request -> {
            var tempCors = new CorsConfiguration();
            tempCors.setAllowedOrigins(List.of("http://localhost:8080"));
            tempCors.setAllowedMethods(List.of("GET","POST", "PUT"));
            tempCors.setAllowedHeaders(List.of("*"));
            return tempCors;
            }));
        return http.build(); 
    }
}