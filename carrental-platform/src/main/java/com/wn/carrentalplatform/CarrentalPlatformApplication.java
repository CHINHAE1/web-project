package com.wn.carrentalplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wn.carrentalplatform.mapper")  // 扫描Mapper接口
public class CarrentalPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrentalPlatformApplication.class, args);
    }

}
