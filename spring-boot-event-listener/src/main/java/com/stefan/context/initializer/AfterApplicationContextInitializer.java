package com.stefan.context.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description: ${todo}
 * @Author: Stefan
 * @Date: 2019/10/21 2:50 PM
 */
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class AfterApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("<===AfterApplicationContextInitializer===>");
    }
}
