package com.chan;

//import com.chan.feign.MyFeign;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

//    @Autowired
//    private MyFeign myFeign;

    @RequestMapping(value = "/test/{value}", method = RequestMethod.GET)
    public String test(@PathVariable String value) {
        return value;
    }

//    @RequestMapping(value = "/feignTest/{value}", method = RequestMethod.GET)
//    public String feignTest(@PathVariable String value) {
//        return myFeign.feignTest(value);
//    }

    @RequestMapping(value = "/hello/{value}", method = RequestMethod.GET)
    public String hello(@PathVariable String value) {
        //输出日志的主要作用是想知道zuul是否转发请求成功
        System.err.println("this is consume...");
        return value;
    }

}
