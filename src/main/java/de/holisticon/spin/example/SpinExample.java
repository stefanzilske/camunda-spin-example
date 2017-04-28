package de.holisticon.spin.example;

import org.camunda.bpm.application.ProcessApplication;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by stefanzilske on 28.04.17.
 */
@SpringBootApplication
@ProcessApplication
public class SpinExample {

    @Bean
    public static SpinProcessEnginePlugin spinPlugin() {
        return new SpinProcessEnginePlugin();
    }

    public static void main(String[] args) {
        SpringApplication.run(SpinExample.class, args);
    }
}
