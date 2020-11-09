package com.thb.service;

import com.thb.domain.Cart;
import com.thb.domain.Lesson;

import java.util.List;

public interface ICartService {
    public List<Cart> getAllCart(int id);

    public void addCart(int uid,int lid);

    void delCart(Integer id);

    Boolean inCart(int uid, int lid);
}
