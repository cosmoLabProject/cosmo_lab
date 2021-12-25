package com.example.cosmo_lab.admin.controller;

import com.example.cosmo_lab.admin.model.mapper.AdminMapper;
import com.example.cosmo_lab.admin.model.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/checkDb")
    public String checkDb() throws Exception {
        int result = adminService.checkDb();
        System.out.println(result);
        return "admin/admin";
    }
}
