package com.example.springboottestplaceholder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhixiao.mzx
 * @date 2019/12/14
 */
@Slf4j
@Component
public class TestProxyByCglib {
    @Value("${second-config:ccc}")
    public String second;

    public String getSecond() {
        log.warn("call getSecond, value: {}, stack: ", second, new Throwable());
        return second;
    }

    public void testAop() {
        log.warn("in testAop");
    }
}
