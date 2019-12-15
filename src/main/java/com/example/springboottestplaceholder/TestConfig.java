package com.example.springboottestplaceholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author zhixiao.mzx
 * @date 2019/12/14
 */
@Component
public class TestConfig {
    @Value("${first-config:aaa}")
    public String first;
}
