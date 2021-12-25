package com.example.cosmo_lab.admin.model.service;

import com.example.cosmo_lab.admin.model.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public int checkDb() throws Exception {
        return adminMapper.checkDb();
    }
}
