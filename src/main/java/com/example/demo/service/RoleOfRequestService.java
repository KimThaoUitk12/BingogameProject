package com.example.demo.service;

import com.example.demo.model.RoleOfRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface RoleOfRequestService {
   RoleOfRequest findById(int id);
   List<RoleOfRequest> findAll();
}
