//package com.youcode.travelease.security;
//
//import com.youcode.travelease.filter.CustomAuthenticationFilter;
//import com.youcode.travelease.filter.CustomAuthorizationFilter;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    private final UserDetailsService userDetailsService;
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    /**
//     * Creates an instance with the default configuration enabled.
//     */
//    public SecurityConfig ( UserDetailsService userDetailsService , BCryptPasswordEncoder bCryptPasswordEncoder ) {
//        this.userDetailsService = userDetailsService;
//        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//    }
//
//    @Override
//    protected void configure ( AuthenticationManagerBuilder auth ) throws Exception {
//        auth.userDetailsService (  userDetailsService).passwordEncoder ( bCryptPasswordEncoder );
//    }
//
//    @Override
//    protected void configure ( HttpSecurity http ) throws Exception {
//        CustomAuthenticationFilter customAuthenticationFilter =
//                new CustomAuthenticationFilter(authenticationManagerBean ());
//
//        customAuthenticationFilter.setFilterProcessesUrl ( "/api/login" );
//
//        http.csrf ().disable ();
//        http.sessionManagement ().sessionCreationPolicy ( STATELESS );
//        http.authorizeRequests ().anyRequest ().authenticated ();
//        http.addFilter ( customAuthenticationFilter  );
//        http.addFilterBefore ( new CustomAuthorizationFilter (), UsernamePasswordAuthenticationFilter.class );
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean ();
//    }
//}
