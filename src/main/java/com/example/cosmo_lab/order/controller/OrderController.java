package com.example.cosmo_lab.order.controller;

import com.example.cosmo_lab.item.dto.Item;
import com.example.cosmo_lab.order.dto.Order;
import com.example.cosmo_lab.order.mapper.OrderMapper;
import com.example.cosmo_lab.user.UserMapper;
import com.example.cosmo_lab.user.model.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserMapper  userMapper;


   private static final Logger logger = LoggerFactory.getLogger(OrderController.class);



    @RequestMapping(value="/orderDetail", method = RequestMethod.GET)
   public void orderlist() throws Exception{

        logger.info("order page 성공");

   }



    //주문정보 view로 넘겨주기
   @RequestMapping(value = "/order/{product_id}", method = RequestMethod.POST)
   public String orderPage(@PathVariable int product_id,Model model,HttpSession session) throws Exception {


       logger.info("진입");


       //상품정보
       Item item = orderMapper.getOrder(product_id);
       model.addAttribute("item", item);


       //회원정보
       // 세션 객채 안에 있는 id 저장
//      String id = (String) session.getAttribute("userID");

      String id="aaa";
      session.setAttribute("UserID",id);
      logger.info("세션에 저장된 아이디 >>> " + id);

      int user_id = userMapper.getUserID(id);

      model.addAttribute("us",userMapper.getUserID(id));
      model.addAttribute("us",userMapper.getUser(user_id));


//     orderMapper.insertOrder();
//     orderMapper.OrderDetail();

//       //로그인 할 경우,
//       if (us == null) {
//           session.setAttribute("us",null);
//           return "redirect:/login";
//       }else {
//           session.setAttribute("us",us);
//           return "/orderDetail";
//       }

            return "/orderDetail";
   }

     //주문정보 DB
    @RequestMapping(value = "/orderResult", method = RequestMethod.POST)
    public String insertOrder(int quantity, Order order, HttpSession session){


        //회원 정보 가져오기
        UserDao userDao =(UserDao) session.getAttribute("userDao");
        String id = (String) session.getAttribute("userID");

        //상품 정보 가져오기


        orderMapper.insertOrder();
        orderMapper.OrderDetail();

        int order_id = order.getOrder_id();
        order.setOrder_id(order_id);

//        orderMapper.insertOrder(new OrderDetail(quantity), id);

        return "redirect:/liplist";
    }

}
