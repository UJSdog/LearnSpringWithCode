package com.ujsdog.ioc.aspectAnnotationJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

/**
 * @author 茅伟龙
 * @createTime 2019-11-06 11:15
 */
@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.ujsdog.ioc.aspectAnnotationJ.*.*(..))")
    public void myPointCut(){}
    @Before("myPointCut()")
    public void myBefore(JoinPoint jp){
        System.out.print("前置通知:模拟权限检查,");
        System.out.print("目标类是"+jp.getTarget());
        System.out.println(",被植入增强处理的目标方法为:"+jp.getSignature().getName());
    }
    @AfterReturning("myPointCut()")
    public void myAfterReturning(JoinPoint jp){
        System.out.print("后置通知:模拟记录日志...");
        System.out.println(",被植入增强处理的目标方法为:"+jp.getSignature().getName());
    }
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint pj)throws Throwable{
        System.out.println("环绕开始!模拟开启事务");
        Object obj = pj.proceed();
        System.out.println("环绕结束!模拟关闭事物");
        return obj;
    }
    @AfterThrowing(value = "myPointCut()",throwing = "e")
    public void myAfterThrowing(JoinPoint jp,Throwable e){
        System.out.println("err:"+e.getMessage());
    }
    @After("myPointCut()")
    public void myAfter(){
        System.out.println("最终通知:模拟释放资源");
    }
}