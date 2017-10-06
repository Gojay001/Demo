package aop.config.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by Gojay on 2017/10/6.
 */
@Aspect
public class MyAdvice {
    //抽取出来统一管理，也可以在每个注解中复制
    @Pointcut("execution(* aop.config.service.*ServiceImpl.*(..))")
    public void pointcut(){}

    //指定前置通知，并指定切入点
    @Before("MyAdvice.pointcut()")
    public void before(){
        System.out.println("前置通知！");
    }

    @AfterReturning("execution(* aop.config.service.*ServiceImpl.*(..))")
    public void afterReturning(){
        System.out.println("后置通知！（出现异常不会调用）");
    }

    @Around("MyAdvice.pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕通知前！");
        Object proceed = proceedingJoinPoint.proceed();//调用目标方法
        System.out.println("环绕通知后！");
        return proceed;
    }

    @AfterThrowing("MyAdvice.pointcut()")
    public void afterException(){
        System.out.println("出现异常！");
    }

    @After("MyAdvice.pointcut()")
    public void after() {
        System.out.println("后置通知！（出现异常也会调用）");
    }
}
