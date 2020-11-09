package com.thb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@EnableTransactionManagement
public class SpringbootMybatisApplication {

	public static void main(String[] args) {
		run(SpringbootMybatisApplication.class, args);
	}

}
