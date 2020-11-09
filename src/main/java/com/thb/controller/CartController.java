package com.thb.controller;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.thb.domain.Cart;
import com.thb.domain.Order;
import com.thb.service.ICartService;
import com.thb.service.IOrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Transactional
public class CartController {

    @Autowired
    private ICartService cartService;

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/getCart")
    public List<Cart> getCart(int id){
        return cartService.getAllCart(id);
    }

    @RequestMapping("addCart")
    public String addCart(int uid,int lid){
        cartService.addCart(uid,lid);
        return "ok";
    }

    @RequestMapping("buyCart")
    public List<Order> buyCart(@RequestBody List<Cart> carts){
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < carts.size(); i++) {
            Order order = new Order();
            order.setLesson_id(carts.get(i).getLesson_id());
            order.setLesson_price(carts.get(i).getLesson_price());
            order.setUser_id(carts.get(i).getUser_id());
            order.setOrder_date(new Date());
            orderService.addOrder(order);
            orders.add(order);
            cartService.delCart(carts.get(i).getId());
        }
        return orders;
    }

    @RequestMapping("inCart")
    public String inCart(int uid,int lid){
        Boolean flag=cartService.inCart(uid,lid);
        System.out.println(flag+"-----是否在购物车内");
        if (flag){
            return "noincart";
        }else {
            return "incart";
        }
    }

}
