package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UserDetails userDetails;


    public String getRole(int id) {
        Query<User> userQuery=sessionFactory.getCurrentSession().createQuery("FROM User u where u.id=:id");
        userQuery.setParameter("id",id);
        return userQuery.uniqueResult().getRole();
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
