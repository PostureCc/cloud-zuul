//package com.chan.feign;
//
//import org.springframework.stereotype.Component;
//
////注意这个注解很重要 没有不生效 测试是否能够成功熔断:把port1项目停止(模拟该服务挂机)
//@Component
//public class MyFeignImpl implements MyFeign {
//
//    @Override
//    public String feignTest(String value) {
//        return "feign error...";
//    }
//}
