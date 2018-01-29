package com.tghelper.globalosin.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * Created by infamouSs on 1/28/18.
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {
    
    @Bean
    public ClassLoaderTemplateResolver templateResolver() {
        
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        
        templateResolver.setPrefix("static/");
        templateResolver.setCacheable(true);
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        templateResolver.setCharacterEncoding("UTF-8");
        
        return templateResolver;
    }
    
    @Bean
    public SpringTemplateEngine templateEngine() {
        
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        
        return templateEngine;
    }
    
    @Bean
    public ViewResolver viewResolver() {
        
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        
        return viewResolver;
    }
}
