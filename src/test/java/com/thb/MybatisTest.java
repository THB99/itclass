package com.thb;

import com.thb.domain.*;
import com.thb.mapper.*;
import com.thb.service.ICartService;
import com.thb.service.ILessonService;
import com.thb.service.IOrderService;
import com.thb.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.Or;
import org.omg.CORBA.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.nio.cs.US_ASCII;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class MybatisTest {
    @Autowired
    private IUserService userService;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private LessonMapper lessonMapper;

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private ILessonService lessonService;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private ICartService cartService;
    @Test
    public void run1(){
//        User thb999 = userMapper.login("thb999","111111");
//        System.out.println(thb999);
        List<Lesson> all = lessonMapper.findAll();
        System.out.println(all);
    }

    @Test
    public void run2(){
        Lesson lesson=lessonMapper.findLessonByid(1);
        System.out.println(lesson);
    }
    @Test
    public void run3(){
        Teacher teacher = teacherMapper.findById(1);
        System.out.println(teacher);
    }
    @Test
    public void run4(){
        Lesson info = lessonService.findInfo(1);
        System.out.println(info);
    }

    @Test
    public void run5(){
        User user = userService.login("thb999", "111111");
        if (user==null){
            User user1 = new User();
            user1.setId(0);
            System.out.println(user1);
        }else {
            System.out.println(user);
        }

    }
    @Test
    public void run6(){
        List<Cart> cart = cartMapper.findCart(2);
        System.out.println(cart);
    }

    @Test
    public void run7(){
        cartMapper.addCart(1, 6);
    }

    @Test
    public void run8(){
        Order order = new Order();
        order.setUser_id(1);
        order.setLesson_id(1);
        order.setLesson_price(50);
        order.setOrder_date(new Date());
        orderMapper.addOrder(order);
    }

    @Test
    public void run9(){
        cartService.delCart(7);
    }

    @Test
    public void run10(){
        Order order = orderMapper.findbuyOrder(1, 4);
        System.out.println(order);
    }

    @Test
    public void run11(){
        Cart cart = cartMapper.inCart(1, 1);
        System.out.println(cart);
    }

    @Autowired
    private IOrderService orderService;

    @Test
    public void run12(){
        Order order = new Order();
        order.setOrder_date(new Date());
        order.setLesson_id(1);
        order.setUser_id(1);
//        orderMapper.addOrder(order);
        orderService.addOrder(order);
        System.out.println(order);
    }

    @Test
    public void run13(){
        List<Lesson> lessons = lessonMapper.findmylesson(1);
        System.out.println(lessons);
    }

    @Test
    public void run14(){
        List<Order> ordernopay = orderMapper.findOrdernopay(1);
        System.out.println(ordernopay);
    }

    @Test
    public void run15(){
        List<Lesson> alllesson = lessonMapper.findAlllesson();
        System.out.println(alllesson);
    }


}
