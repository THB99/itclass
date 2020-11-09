package com.thb.service;

import com.thb.domain.Order;

import java.util.List;

public interface IOrderService {

    public void addOrder(Order order);

    Boolean isbuyorder(int uid, int lid);

    public void pay(Order order);


    void buyone(Order order);

    List<Order> getOrdernopay(int id);

    Order inordernopay(int uid, int cid);
}
