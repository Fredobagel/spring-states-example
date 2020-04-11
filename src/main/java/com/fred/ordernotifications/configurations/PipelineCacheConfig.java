package com.fred.ordernotifications.configurations;

import com.fred.ordernotifications.models.pipeline.OrderPipeline;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Configuration
public class PipelineCacheConfig {
    // Google guava cache. Works like a ConcurrentHashmap with self expiring mechanism
    // or you can add a loader, which makes web call / whatever you want if key is missing.
    @Bean
    Cache<UUID, OrderPipeline> orderPipelineCache() {
        return CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.HOURS).build();
    }
}
