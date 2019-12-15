package com.example.springboottestplaceholder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.Advised;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
public class SpringBootTestPlaceholderApplication implements CommandLineRunner {
    @Autowired
    private TestConfig testConfig;

    @Autowired
    private TestProxyByCglib testProxyByCglib;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestPlaceholderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.warn("first: {}", testConfig.first);

        log.warn("get second value by call getSecond(), value: {}, class: {}",
            testProxyByCglib.getSecond(), testProxyByCglib.getClass().getSimpleName());
        log.warn("get second value by property name, value: {}, class: {}",
            testProxyByCglib.second, testProxyByCglib.getClass().getSimpleName());

        Object target = ((Advised)testProxyByCglib).getTargetSource().getTarget();
        log.warn("get second value by property name of cglib proxy target, value: {}, class: {}",
            ((TestProxyByCglib)target).second, target.getClass().getSimpleName());
    }
}
