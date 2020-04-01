package com.saxo.assignment.aop;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 *This is the config class for pointcut which are used by Publisher class to apply advice and publish events
 *
 */
@Configuration
public class CommonJoinPointConfig {
	
    @Pointcut("execution(* com.saxo.assignment.client.ClientServiceImpl.addPortfolio(..))")
    public void emailNotificationPointCut() {}
    
    @Pointcut("execution(* com.saxo.assignment.client.ClientServiceImpl.updatePortfolio(..))")
    public void pushMessageNotificationPointCut() {}

    @Pointcut("execution(* com.saxo.assignment.client.ClientServiceImpl.deletePorfolio(..))")
    public void textNotificationPointCut() {}
}
