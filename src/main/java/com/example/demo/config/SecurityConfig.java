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
                .authoritiesByUsernameQuery("select distinct username, role from user where username=?").passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//
//        http.antMatcher("/**").authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated()
//                .and().oauth2Login();



        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, roleOfRequestService.findById(1).getEndpoint())
                .hasAnyRole(roleOfRequestService.findById(2).getRole(),roleOfRequestService.findById(1).getRole()).and().csrf().disable().httpBasic();

        List<RoleOfRequest> roleOfRequestList = roleOfRequestService.findAll();

        for(int i=2;i<roleOfRequestList.size();i++){
            http.authorizeRequests()
                    .antMatchers(HttpMethod.valueOf(roleOfRequestList.get(i).getMethod()), roleOfRequestList.get(i).getEndpoint())
                    .hasRole(roleOfRequestList.get(i).getRole()).and().csrf().disable().httpBasic();
        }

    }
}
