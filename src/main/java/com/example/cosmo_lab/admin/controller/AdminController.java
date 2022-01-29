package com.example.cosmo_lab.admin.controller;

import com.example.cosmo_lab.admin.model.dto.AddItemDto;
import com.example.cosmo_lab.admin.model.dto.ItemListDto;
import com.example.cosmo_lab.admin.model.dto.ModifyItemDto;
import com.example.cosmo_lab.admin.model.mapper.AdminMapper;
import com.example.cosmo_lab.admin.model.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

//    private Logger log = LoggerFactory.getLogger(getClass());

    @GetMapping
    public String admin() throws Exception {
        
//        model.addAttribute("sales", adminService.getDeliveries);
        return "admin/admin";
    }

    @GetMapping("/add-item-form")
    public String itemForm() throws Exception {
        return "admin/addItem";
    }

    @GetMapping("/items")
    public String items(Model model) throws Exception {
        List<ItemListDto> items = new ArrayList<>();
        items = adminService.items();
        log.info("items={}", items);
        model.addAttribute("items", items);
        return "admin/itemList";
    }

    @GetMapping("/delivery")
    public String delivery() throws Exception {
        return "admin/delivery";
    }

    @GetMapping("/qna")
    public String qna() throws Exception {
        return "admin/qna";
    }

    @GetMapping("/members")
    public String members() throws Exception {
        return "admin/memberManagement";
    }

    @PostMapping("/addItem")
    public String addItem(@ModelAttribute("item") AddItemDto item, Model model) {

        int profit = item.getSellingPrice() - item.getOriginalPrice();
        item.setProfit(profit);
        item.setItemImage(item.getItemImage());

        log.info("image={}", item.getItemImage());
        log.info("category={}", item.getCategory());
        log.info("status={}", item.getStatus());
        log.info("itemName={}", item.getItemName());
        log.info("originalPrice={}", item.getOriginalPrice());
        log.info("sellingPrice={}", item.getSellingPrice());
        log.info("profit={}", item.getProfit());
        log.info("itemDescription={}", item.getItemDescription());

        int result = adminService.addItem(item);
        log.info("result={}", result);
        model.addAttribute("item", item);
        return "redirect:/admin/items";
    }

    @GetMapping("/modifyForm/{productId}")
    @ResponseBody
    public ModifyItemDto modifyForm(@PathVariable("productId") int productId) {

        ModifyItemDto data = adminService.modifyForm(productId);
        log.info("productId={}", data.getProductId());
        return data;
    }

    @PostMapping("/modifyItem")
    public String modifyItem(@ModelAttribute("item") ModifyItemDto itemDto) {
        log.info("itemName={}", itemDto.getProductName());
        log.info("itemPrice={}", itemDto.getPrice2());
        return "redirect:/admin/items";
    }
}