package com.example.cosmo_lab.item.controller;

import com.example.cosmo_lab.item.dto.Item;
import com.example.cosmo_lab.item.model.ItemMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class ItemController {

    @Autowired
    private ItemMapper itemMapper;

    //로그 기록용
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);


    //립 상품 조회
    @RequestMapping(value = "/lip", method = RequestMethod.GET)
    public String itemlistAll(Item item, Model model) throws Exception{

        logger.info("진입");

        //가져오기
        List<Item> itemList = itemMapper.getItemList();
        model.addAttribute("itemList",itemList);

        logger.info("성공");
        System.out.println(itemList.toString());

        //view
//        model.addAttribute("item",item);

        return "lipList";

    }

    //립 상품 상세 페이지
    @RequestMapping(value = "/lip/detail/{product_id}", method = RequestMethod.GET)
    public String itemDetail(@PathVariable int product_id, Model model) throws Exception{


       logger.info("진입 성공");
       Item item = itemMapper.getItem(product_id);
       model.addAttribute("item", item);

       System.out.println(product_id);
       return "lipDetail";
    }

}
