package com.example.cosmo_lab.admin.model.service;

import com.example.cosmo_lab.admin.model.dto.AddItemDto;
import com.example.cosmo_lab.admin.model.dto.ItemListDto;
import com.example.cosmo_lab.admin.model.dto.ModifyItemDto;
import com.example.cosmo_lab.admin.model.dto.OrderDetail;
import com.example.cosmo_lab.admin.model.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<OrderDetail> getDeliveries() {
        return adminMapper.getDeliveries();
    }

    @Override
    public int addItem(AddItemDto item) {
        return adminMapper.addItem(item);
    }

    @Override
    public List<ItemListDto> items() {
        return adminMapper.items();
    }

    @Override
    public ModifyItemDto modifyForm(int productId) {
        return adminMapper.modifyForm(productId);
    }
}