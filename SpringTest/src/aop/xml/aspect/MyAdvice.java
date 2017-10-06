package aop.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Gojay on 2017/10/5.
 */
public class MyAdvice {
    public void before(){
        System.out.println("前置通知！");
    }

    public void afterReturning(){
        System.out.println("后置通知！（出现异常不会调用）");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕通知前！");
        Object proceed = proceedingJoinPoint.proceed();//调用目标方法
        System.out.println("环绕通知后！");
        return proceed;
    }

    public void afterException(){
        System.out.println("出现异常！");
    }

    public void after() {
        System.out.println("后置通知！（出现异常也会调用）");
    }
}
