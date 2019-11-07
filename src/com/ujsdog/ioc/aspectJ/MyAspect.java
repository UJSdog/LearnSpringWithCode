package com.ujsdog.ioc.aspectJ;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
/**
 * @author 茅伟龙
 * @createTime 2019-11-06 11:15
 */
public class MyAspect {
    public void myBefore(JoinPoint jp){
        System.out.print("前置通知:模拟权限检查,");
        System.out.print("目标类是"+jp.getTarget());
        System.out.println(",被植入增强处理的目标方法为:"+jp.getSignature().getName());
    }
    public void myAfterReturning(JoinPoint jp){
        System.out.print("后置通知:模拟记录日志...");
        System.out.println(",被植入增强处理的目标方法为:"+jp.getSignature().getName());
    }
    public Object myAround(ProceedingJoinPoint pj)throws Throwable{
        System.out.println("环绕开始!模拟开启事务");
        Object obj = pj.proceed();
        System.out.println("环绕结束!模拟关闭事物");
        return obj;
    }
    public void myAfterThrowing(JoinPoint jp,Throwable e){
        System.out.println("err:"+e.getMessage());
    }
    public void myAfter(){
        System.out.println("最终通知:模拟释放资源");
    }
}