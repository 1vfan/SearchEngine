package com.stefan.context.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @Description: ${todo}
 * @Author: Stefan
 * @Date: 2019/10/21 2:59 PM
 */
@Order(Ordered.HIGHEST_PRECEDENCE + 1)
public class AfterApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("<==AfterApplicationListener==>: " + event.getTimestamp());
    }
}