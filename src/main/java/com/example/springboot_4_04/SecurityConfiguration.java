package com.example.springboot_4_04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.swing.*;
import javax.validation.OverridesAttribute;

@Configuration
@EnableWebSecurity.
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
        @Autowired
        private SSUserDetailsService userDetailService;

        @Autowired
        private UserRepository UserRepository;

        @Override
        public UserDetailsService userDetailsService( throws Exception)
        return new SSUserDetailsService(appUserRepository);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/").access("hasAnyAuthority('user','ADMIN')")
                .antMatchers("/h2-console/* *")
                .access("hasAnyAuthority('USER', 'ADMIN')")
                .antMatchers("/admin").access("hasAuthority('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .logout().logoutRequestMatcher(new antPathRequestMatcher('/logout'))
                .logoutSuccessUrl("/login").permitAll()
                .and()
                .httpBasic;
        http
                .csrf().disable();
        http
                .headers().frameOptions().disable();

    }
        @Override
        protected void configure(AuthenticationManagerBuilder auth)throws Exception{
        /*
            auth.inMemoryAuthentication().withUser("user")
                    .password(passwordEncoder().encode("password"))
                    .authorities("USER")
                    .and()
                    .withUser("user2")
                    .password(passwordEncoder().encode("password"))
                    .authorities("USER");

         */
       auth.userDetailService(userDetailsServiceBean()).passwordEncoder[passwordEncoder());
        }
    }


