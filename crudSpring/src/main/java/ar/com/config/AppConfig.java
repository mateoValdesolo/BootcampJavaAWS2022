package ar.com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"ar.com.BO", "ar.com.DAO", "ar.com.controller"})
public class AppConfig {

}
