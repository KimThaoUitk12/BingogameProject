package com.example.demo.config;
import com.example.demo.model.RoleOfRequest;
import com.example.demo.model.User;
import com.example.demo.service.RoleOfRequestService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.util.List;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RoleOfRequestService roleOfRequestService;

    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("select username, password, true from user where username=?")
                .authoritiesByUsernameQuery("select username, role from sec_function where username=?").passwordEncoder(new BCryptPasswordEncoder());


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, roleOfRequestService.findById(1).getEndpoint()).hasAnyRole("ADMIN","USER");

                List<RoleOfRequest> roleOfRequestList = roleOfRequestService.findAll();
                for (RoleOfRequest roleOfRequest : roleOfRequestList){
                    http.authorizeRequests()
                            .antMatchers(HttpMethod.valueOf(roleOfRequest.getMethod()), roleOfRequest.getEndpoint()).hasRole(roleOfRequest.getRole());
                }
                http.httpBasic().and()
                        .authorizeRequests();
    }
}
