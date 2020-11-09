package com.thb.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private int order_id;
    private int user_id;
    private int lesson_id;
    private int lesson_price;
    private Date order_date;
    private int order_state;
    private String lesson_info;
    private String t_name;
}
