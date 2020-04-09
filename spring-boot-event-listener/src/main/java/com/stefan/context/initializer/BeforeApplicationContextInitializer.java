package com.stefan.context.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description: ${todo}
 * @Author: Stefan
 * @Date: 2019/10/21 2:46 PM
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class BeforeApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("<===BeforeApplicationContextInitializer===>");
    }
}
