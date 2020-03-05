package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}password").roles("USER")
                .and().withUser("admin").password("{noop}password").roles("ADMIN","USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/welcome").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/addEmployee").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/delEmp/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/updateEmployee/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }


}
