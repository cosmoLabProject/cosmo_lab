package com.example.cosmo_lab.admin.model.service;

import com.example.cosmo_lab.admin.model.dto.AddItemDto;
import com.example.cosmo_lab.admin.model.dto.ItemListDto;
import com.example.cosmo_lab.admin.model.dto.ModifyItemDto;
import com.example.cosmo_lab.admin.model.dto.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {

    List<OrderDetail> getDeliveries();

    int addItem(AddItemDto item);

    List<ItemListDto> items();

    List<ItemListDto> searchItems(int category, String keyword);

    ModifyItemDto modifyForm(int productId);

    int modifyItem(ModifyItemDto modifyItemDto);
}