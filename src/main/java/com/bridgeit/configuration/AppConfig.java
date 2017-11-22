package com.bridgeit.configuration;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableAsync
@ComponentScan(basePackages = "com.bridgeit")
public class AppConfig {
	}
  
    
  
