package com.chan;

import java.io.File;
import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;

@SpringBootApplication
//标注这是Eureka的客户端
@EnableEurekaClient
//标注这是Zuul的代理入口
@EnableZuulProxy
public class ZuulServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ZuulServiceApplication.class).web(true).run(args);
    }

    @PostConstruct
    public void zuulInit() {
        FilterLoader.getInstance().setCompiler(new GroovyCompiler());
        // 加载目录
        String scriptRoot = System.getProperty("zuul.filter.root", "groovy/filters")/*.concat("/")*/;
        // def:"5"表示刷新的间隔时间 单位:s
        String refreshInterval = System.getProperty("zuul.filter.refreshInterval", "5");
        if (scriptRoot.length() > 0) scriptRoot = scriptRoot + File.separator;
        try {
            FilterFileManager.setFilenameFilter(new GroovyFileFilter());
            FilterFileManager.init(Integer.parseInt(refreshInterval), scriptRoot + "pre",
                    scriptRoot + "route", scriptRoot + "post");
        } catch (Exception e) {
            System.err.println(String.format("e.msg:%s \ne:%s", e.getMessage(), e));
        }
    }

}
