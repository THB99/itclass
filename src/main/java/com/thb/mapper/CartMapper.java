package com.thb.mapper;

import com.thb.domain.Cart;
import com.thb.domain.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper()
public interface CartMapper {

    public List<Cart> findCart(int user_id);

    public void addCart(@Param(value = "uid") int uid, @Param("lid") int lid);

    void delCart(Integer id);


    Cart inCart(@Param("uid") int uid,@Param("lid") int lid);
}

