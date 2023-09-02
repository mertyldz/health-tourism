package com.allianz.healthtourism.configuration;


import com.allianz.healthtourism.database.repository.UserEntityRepository;
import com.allianz.healthtourism.utils.security.JWTFilter;
import com.allianz.healthtourism.utils.security.SecurityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private static final String[] AUTH_WHITELIST = {
            "/auth/**",
            "/swagger-ui/**",
            "v3/api-docs/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/api/public/**",
            "/api/public/authenticate",
            "/actuator/*",
            "/swagger-ui/**",
            "/doctor/get-all-filter",
            "/flight/get-all-filter",
            "/hospital/get-all-filter",
            "/hotel/get-all-filter"

    };
    private static final String[] DOCTOR_AUTH_WHITELIST = {
            "/examination",
            "/examination/**",
            "/patient/add-examination"
    };

    private static final String[] ADMIN_AUTH_WHITELIST = {
            "/doctor",
            "/doctor/**",
            "/flight",
            "/flight/**",
            "/hospital",
            "/hospital/**",
            "/hotel",
            "/hotel/**",
            "/plane",
            "/plane/**",
            "/reservation/get-all-filter"
    };

    private static final String[] USER_AUTH_WHITELIST = {
            "/patient",
            "/patient/**",
            "/reservation",
            "/reservation/**"
    };

    @Autowired
    private UserEntityRepository userRepo;
    @Autowired
    private JWTFilter filter;
    @Autowired
    private SecurityService uds;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        http.csrf(AbstractHttpConfigurer::disable);
        http.httpBasic(AbstractHttpConfigurer::disable);

        http.cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(List.of("*"));
            configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
            configuration.setAllowedHeaders(List.of("*"));
            configuration.setExposedHeaders(List.of("Content-Disposition"));
            return configuration;

        }));

        http.authorizeHttpRequests(authorize -> {
            authorize
                    .requestMatchers(AUTH_WHITELIST).permitAll()
                    .requestMatchers(DOCTOR_AUTH_WHITELIST).hasRole("DOCTOR")
                    .requestMatchers(ADMIN_AUTH_WHITELIST).hasRole("ADMIN")
                    .requestMatchers(USER_AUTH_WHITELIST).hasRole("USER");
        });

        http.userDetailsService(uds).exceptionHandling(ex -> ex.authenticationEntryPoint(
                ((request, response, authException) ->
                        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized"))));

        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }


}
