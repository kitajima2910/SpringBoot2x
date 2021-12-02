package com.hoaipx.learn2021.common.config.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hoaipx.learn2021.common.Constant;
import com.hoaipx.learn2021.entity.User;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private JwtTokenProvider jwtTokenProvider;

    private AuthenticationManager authenticationManager;

    private Map<String, Object> resultJson;

    public AuthenticationFilter(AuthenticationManager authenticationManager, ApplicationContext applicationContext) {
        resultJson = new HashMap<>();
        resultJson.put("timestamp", System.currentTimeMillis());
        resultJson.put("path", Constant.URL_SIGN_IN);

        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(Constant.URL_SIGN_IN);

        this.jwtTokenProvider = applicationContext.getBean(JwtTokenProvider.class);
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        User user = new ObjectMapper().readValue(request.getInputStream(), User.class);
        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), new ArrayList<>()));
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException {

        resultJson.put("status", HttpServletResponse.SC_UNAUTHORIZED);
        resultJson.put("error", "Unauthorized");
        resultJson.put("message", "Check username and password");

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(resultJson));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain, Authentication authentication) throws IOException {

        resultJson.put("status", HttpServletResponse.SC_OK);
        resultJson.put("message", "Login Successfully");

        String token = this.jwtTokenProvider.generateJwtToken(authentication);

        response.addHeader("Authorization","Bearer " + token);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new ObjectMapper().writeValueAsString(resultJson));
    }
}
