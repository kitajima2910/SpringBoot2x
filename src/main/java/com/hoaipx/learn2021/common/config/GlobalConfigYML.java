package com.hoaipx.learn2021.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "config")
public class GlobalConfigYML {

    private String urlSignIn;

}
