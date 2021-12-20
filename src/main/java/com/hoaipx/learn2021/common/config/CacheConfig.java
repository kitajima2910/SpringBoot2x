package com.hoaipx.learn2021.common.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean(name = "springCM")
    public CacheManager cacheManager() {
//        return new ConcurrentMapCacheManager("entities");
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<>(2);
        caches.add(new ConcurrentMapCache("dev-cache"));
        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }

}
