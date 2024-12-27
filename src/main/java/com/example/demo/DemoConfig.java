package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.parameters.P;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class DemoConfig
{

    @Autowired
    DemoSecurityService demoSecurityService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/doctor/**").hasAuthority("DOCTOR_DETAILS_AUTHORITY")
                        .requestMatchers("/deo/**").hasAuthority("DEO_DETAILS_AUTHORITY")
                        .requestMatchers("/ceo/**").hasAuthority("CEO_DETAILS_AUTHORITY")
                        .requestMatchers("/schedule/**").hasAuthority("SCHEDULE_APPOINTMENTS")
                        .requestMatchers("/**").permitAll()
                )
                .formLogin(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http)  throws Exception
    {
        AuthenticationManagerBuilder builder =  http.getSharedObject(AuthenticationManagerBuilder.class);
                builder.userDetailsService(demoSecurityService)
                .passwordEncoder(getPE());

        return builder.build();
    }

    @Bean
    public PasswordEncoder getPE() {
        return new BCryptPasswordEncoder();
    }

}


