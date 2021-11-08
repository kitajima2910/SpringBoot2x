package com.hoaipx.learn2021.pxh;


import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class UserAuditor implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

//        try {
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            if(authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)){
//                return Optional.ofNullable(authentication.getName());
//            }
//            return Optional.empty();
//        } catch (Exception e) {
//            return Optional.empty();
//        }
        return Optional.ofNullable("Hoai");
    }

}
