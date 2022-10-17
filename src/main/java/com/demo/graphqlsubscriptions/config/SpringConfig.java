package com.demo.graphqlsubscriptions.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import graphql.scalars.ExtendedScalars;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class SpringConfig {

    @Bean
    public RuntimeWiringConfigurer runtimeScalarJson() {
        return wiringBuilder -> wiringBuilder.scalar(ExtendedScalars.Json);
    }
}
