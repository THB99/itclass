package com.thb.domain;

import lombok.Data;

@Data
public class Cart {
    private Integer id;
    private Integer user_id;
    private Integer lesson_id;
    private Integer lesson_price;
    private String lesson_info;
    private String teacher_name;
}
