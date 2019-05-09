package com.macaitech.biz.multimodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 模拟炒股
 * @author yuhui.tang
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableFeignClients
public class YnTestUserServiceApp {
	
    public static void main(String[] args) {
        SpringApplication.run(YnTestUserServiceApp.class, args);
    }
    
}
