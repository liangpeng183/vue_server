package com.szcf.vue_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szcf.vue_server.mapper")
public class VueServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueServerApplication.class, args);
        System.out.println("vue后台服务器启动。。。。");
    }

}
