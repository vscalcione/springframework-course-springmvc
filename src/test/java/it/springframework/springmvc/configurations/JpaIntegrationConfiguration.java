package it.springframework.springmvc.configurations;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;

@Configuration
@EnableAutoConfiguration
@ComponentScan("it.springframework.springmvc")
@ActiveProfiles("jpadao")
public class JpaIntegrationConfiguration {

}
