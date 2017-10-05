package com.yestin.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;
import reactor.spring.context.config.EnableReactor;
/**
 * Created by yestin on 2017/10/2.
 */
@Configuration
@EnableReactor
public class ReactorConfig {


    @Bean(name = "reportReactor")
    public Reactor reportReactor(Environment env) {
        return Reactors.reactor().env(env).dispatcher("ringBuffer").get();
    }
}