package com.thb.service.impl;

import com.thb.domain.Cart;
import com.thb.domain.Lesson;
import com.thb.domain.Teacher;
import com.thb.mapper.CartMapper;
import com.thb.mapper.LessonMapper;
import com.thb.mapper.TeacherMapper;
import com.thb.service.ICartService;
import com.thb.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements ICartService {


    @Autowired
    private CartMapper cartMapper;
    @Override
    public List<Cart> getAllCart(int id) {
        return cartMapper.findCart(id);
    }

    @Override
    public void addCart(int uid, int lid) {
        cartMapper.addCart(uid,lid);
    }

    @Override
    public void delCart(Integer id) {
        cartMapper.delCart(id);
    }

    @Override
    public Boolean inCart(int uid, int lid) {
        Cart cart = cartMapper.inCart(uid, lid);
        if (cart==null){
            return true;
        }else {
            return false;
        }
    }
}
