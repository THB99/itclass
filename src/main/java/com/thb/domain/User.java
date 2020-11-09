package com.thb.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sun.management.counter.perf.PerfInstrumentation;

import java.security.PrivateKey;


@Data
public class User {
    private int id;
    private  String username;
    private  String password;
    private String name;
    private String address;
    private String logo;

}
