package me.songha.projectweb.config;

import me.songha.projectweb.resolver.CategoryResolver;
import me.songha.projectweb.resolver.DeviceResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ProjectWebConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/templates/", "classpath:/static/");
    }

    @Bean
    public DeviceResolver getDeviceResolver() {
        return new DeviceResolver();
    }

    @Bean
    public CategoryResolver getCategoryResolver() {
        return new CategoryResolver();
    }
}
