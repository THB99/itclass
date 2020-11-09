package com.thb.mapper;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.thb.domain.Cart;
import com.thb.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper()
public interface OrderMapper {
    public void addOrder(Order order);

    public Order findbuyOrder(@Param("uid") int uid,@Param("lid") int lid);

    public void update_orderstate(int order_id);

    void buyone(int uid, int cid);

    void buyone(Order order);

    List<Order> findOrdernopay(int id);

    Order inordernopay(@Param("uid") int uid,@Param("cid") int cid);
}

