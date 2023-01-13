package com.youcode.travelease.security;

import com.youcode.travelease.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthFilter jwtAutFilter;

    private final UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
        http
                .csrf ().disable ()
                .authorizeRequests ()
                .antMatchers("/api/auth/**").permitAll()
                .anyRequest ()
                .authenticated ()
                .and ()
                .sessionManagement (  )
                .sessionCreationPolicy ( SessionCreationPolicy.STATELESS )
                .and ()
                .authenticationProvider ( authenticationProvider() )
                .addFilterBefore ( jwtAutFilter, UsernamePasswordAuthenticationFilter.class );
        return http.build ();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider ();
        authenticationProvider.setUserDetailsService ( userDetailsService () );
        authenticationProvider.setPasswordEncoder ( passwordEncoder() );
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager( AuthenticationConfiguration config ) throws Exception {
        return config.getAuthenticationManager ();
    }

    @Bean
    public PasswordEncoder passwordEncoder ( ) {
        return NoOpPasswordEncoder.getInstance ();
        //return new BCryptPasswordEncoder (  );
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService ( ) {
            @Override
            public UserDetails loadUserByUsername ( String email ) throws UsernameNotFoundException {
                return userService.loadUserByUsername(email);
            }
        };
    }
}
