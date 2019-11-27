package com.tu.duduse.common.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @author gang.tu
 * @date 2019/10/10 17:33
 */
@Configuration
public class ScheduledThreadPoolConfig implements SchedulingConfigurer {

    @Value("${thread.pool.corePoolSize:10}")
    private int corePoolSize;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(corePoolSize));
    }
}