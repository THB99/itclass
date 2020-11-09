package com.thb.service.impl;

import com.thb.domain.Order;
import com.thb.mapper.OrderMapper;
import com.thb.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public Boolean isbuyorder(int uid, int lid) {
        Order order = orderMapper.findbuyOrder(uid, lid);
        if (order==null){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public void pay(Order order) {
        orderMapper.update_orderstate(order.getOrder_id());
    }

    @Override
    public void buyone(Order order) {
        orderMapper.buyone(order);
    }

    @Override
    public List<Order> getOrdernopay(int id) {
        return orderMapper.findOrdernopay(id);
    }

    @Override
    public Order inordernopay(int uid, int cid) {
        return orderMapper.inordernopay(uid, cid);

    }

}
