package com.hoaipx.learn2021.common.config;

import com.hoaipx.learn2021.common.Constant;
import com.hoaipx.learn2021.common.config.jwt.AuthenticationFilter;
import com.hoaipx.learn2021.common.config.jwt.AuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

            // Turn off cross-site request protection
        http.cors().and().csrf().disable().authorizeRequests()
                // This means that the request "/" does not need to be authenticated
                // .antMatchers(Constant.MATCHERS_URL).permitAll()
                // POST requests to "/login" always allowed whether authenticated or not
                // .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers(Constant.MATCHERS_AUTH).permitAll()
                // The requests need to be authenticated
                .anyRequest().authenticated()
                .and()
                // Authentication
                .addFilter(new AuthenticationFilter(authenticationManager()))
                // Authorization
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
