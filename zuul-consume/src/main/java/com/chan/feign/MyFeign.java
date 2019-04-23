//package com.chan.feign;
//
//import org.springframework.cloud.netflix.feign.FeignClient;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@FeignClient(name = "zuul-service")
//public interface MyFeign {
//
//    @RequestMapping(value = "/test/{value}", method = RequestMethod.GET)
//    String feignTest(@PathVariable("value") String value);
//
//}
