package com.example.demo.service.impl;

import com.example.demo.model.RoleOfRequest;
import com.example.demo.repository.RoleOfRequestRepository;
import com.example.demo.service.RoleOfRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleOfRequestServiceImpl implements RoleOfRequestService {

    @Autowired
    private RoleOfRequestRepository requestRepository;


    @Override
    public RoleOfRequest findById(int id) {
        Optional<RoleOfRequest> roleOfRequest=requestRepository.findById(id);
        return roleOfRequest.isPresent()?roleOfRequest.get():null;
    }

    @Override
    public List<RoleOfRequest> findAll() {
        return requestRepository.findAll();
    }


}
