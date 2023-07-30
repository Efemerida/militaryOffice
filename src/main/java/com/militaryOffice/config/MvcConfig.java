package com.militaryOffice.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

    @EventListener({ApplicationReadyEvent.class})
    private static void openPage() throws IOException {
        Runtime rt=Runtime.getRuntime();
        rt.exec("rundll32 url.dll,FileProtocolHandler "+"http:/localhost:8080/home");
    }
}
