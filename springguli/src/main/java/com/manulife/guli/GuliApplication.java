package com.manulife.guli;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.manulife.guli.mapper")
public class GuliApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuliApplication.class, args);
    }

}
