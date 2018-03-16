package com.tghelper.globalosin.application.security;

import org.springframework.boot.autoconfigure.security.Http401AuthenticationEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * Created by infamouSs on 1/27/18.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                  .cors()
                  .and()
                  .exceptionHandling()
                  .authenticationEntryPoint(new Http401AuthenticationEntryPoint("Unauthenticated"))
                  .and()
                  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                  .authorizeRequests()
                  .antMatchers("/**").permitAll()
                  .anyRequest().permitAll();
    }
}
