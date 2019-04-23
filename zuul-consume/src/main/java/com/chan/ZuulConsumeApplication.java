package com.chan;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
//标注这是Eureka的客户端
@EnableEurekaClient
//@EnableFeignClients//调用者启动时，打开Feign开关
public class ZuulConsumeApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulConsumeApplication.class).web(true).run(args);
    }

}
