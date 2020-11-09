package com.thb.controller;

import com.thb.domain.Cart;
import com.thb.domain.Lesson;
import com.thb.domain.Order;
import com.thb.service.ICartService;
import com.thb.service.ILessonService;
import com.thb.service.IOrderService;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.sql.SQLTransactionRollbackException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Transactional
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @Autowired
    private ILessonService lessonService;

    @RequestMapping("/isbuyorder")
    public String isbuyorder(int uid,int lid){
        boolean flag=orderService.isbuyorder(uid,lid);
        if (flag){
            return "ok";
        }else {
            return "no";
        }
    }

    @RequestMapping("/pay")
    public String pay(@RequestBody List<Order> orders){
        for (int i = 0; i < orders.size(); i++) {
            orderService.pay(orders.get(i));
//            System.out.println(orders.get(i)+"--------------");
        }
        return "ok";
    }

    @RequestMapping("/buyone")
    public List<Order> buyone(int uid,int cid){
        Lesson lesson = lessonService.findInfo(cid);
        Order order = new Order();
        order.setUser_id(uid);
        order.setLesson_id(cid);
        order.setLesson_price(lesson.getPrice());
        order.setOrder_date(new Date());
        orderService.buyone(order);
        ArrayList<Order> orders = new ArrayList<>();
        orders.add(order);
        return orders;
    }
    @RequestMapping("getOrdernopay")
    public List<Order> getOrdernopay(int id){

        return orderService.getOrdernopay(id);
    }

    @RequestMapping("inordernopay")
    public String inordernopay(int uid,int cid){
        Order order = orderService.inordernopay(uid, cid);
        if (order==null){
            return "out";
        }else {
            return "in";
        }
    }


}
