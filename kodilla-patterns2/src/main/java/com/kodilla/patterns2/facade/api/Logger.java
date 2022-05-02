package com.kodilla.patterns2.facade.api;
import com.kodilla.patterns2.aop.calculator.Watcher;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class Logger{
    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

    @Before("execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" +
            "&& args(order, userId) && target(object) ")
    public void logEvent(OrderDto order, Long userId, Object object) {
        LOGGER.info("Class: " + order.getClass().getName() + ", Args: " + "UserId " + userId + ", order " + order);
    }
}