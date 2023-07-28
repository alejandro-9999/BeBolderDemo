package com.bebolder.userservice.infrastructure;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:4200") // Reemplaza con la URL de tu aplicación Angular
                .allowedMethods("POST")
                .allowedHeaders("*"); // Puedes ajustar los encabezados permitidos si es necesario
    }
}