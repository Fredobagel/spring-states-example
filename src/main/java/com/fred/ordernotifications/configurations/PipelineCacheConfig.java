package com.fred.ordernotifications.configurations;

import com.fred.ordernotifications.models.pipeline.OrderPipeline;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Configuration
public class PipelineCacheConfig {
    Cache<UUID, OrderPipeline> orderPipelineCache() {
        return CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.HOURS).build();
    }
}
