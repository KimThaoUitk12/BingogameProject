package com.example.demo.config;
import com.example.demo.repository.RoleOfRequestRepository;
import com.example.demo.service.RoleOfRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RoleOfRequestService roleOfRequestService;





    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}password").roles("USER")
//                .and().withUser("admin").password("{noop}password").roles("ADMIN","USER");
//        auth.userDetailsService(userDetailsService()).passwordEncoder(new SCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, roleOfRequestService.findById(1).getEndpoint()).hasRole(roleOfRequestService.findById(1).getRole())
                .antMatchers(HttpMethod.GET, roleOfRequestService.findById(2).getEndpoint()).hasRole(roleOfRequestService.findById(2).getRole())
                .antMatchers(HttpMethod.POST, roleOfRequestService.findById(3).getEndpoint()).hasRole(roleOfRequestService.findById(3).getRole())
                .antMatchers(HttpMethod.DELETE, roleOfRequestService.findById(4).getEndpoint()+"**").hasRole(roleOfRequestService.findById(4).getRole())
                .antMatchers(HttpMethod.PUT, roleOfRequestService.findById(5).getEndpoint()+"**").hasRole(roleOfRequestService.findById(5).getRole())
//                .antMatchers(HttpMethod.POST,"/addEmployee").hasRole("ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/delEmp/**").hasRole("ADMIN")
//                .antMatchers(HttpMethod.PUT,"/updateEmployee/**").hasRole("ADMIN")
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

//    @Override
//    public UserDetailsService userDetailsService() {
//        //ok for demo
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(users.username("user").password("password").roles("USER").build());
//        manager.createUser(users.username("admin").password("password").roles("USER", "ADMIN").build());
//        return manager;
//    }
}
