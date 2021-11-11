package com.hoaipx.learn2021.common.config;

import com.hoaipx.learn2021.pxh.UserAuditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JPAConfig {

    // Ref: https://viblo.asia/p/spring-jpa-tu-dong-update-database-khi-tao-moi-hoac-update-du-lieu-voi-auditoraware-07LKXMx2ZV4
    @Bean
    public AuditorAware<String> auditorProvider() {
        return new UserAuditor();
    }

}
