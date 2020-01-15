package top.juntech.miaosha.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author juntech
 * @version ${version}
 * @date 2020/1/15 15:17
 * @ClassName 类名
 * @Descripe 描述
 */
@Component
@Aspect
public class LogAspect {
    //定义切点
    @Pointcut("execution(* top.juntech.miaosha.service.impl.*(..))")
    public void logAop(){

    }

//    &&args(name) 里面的参数要与方法对应的参数一致
    @Before("logAop()")
    public void logBefore(){
        System.out.println("前置通知Before");
    }

    /*
    * 后置通知
    * */
    @After("logAop()")
    public void logAfter(){
        System.out.println("后置通知after");
    }

    /*
    * 返回通知
    * */
    @AfterReturning("logAop()")
    public void afterReturning(){
        System.out.println("返回通知AfterReturning");
    }

    /*
    * 异常通知
    * */
    @AfterThrowing("logAop()")
    public void logAfterThrow(){
        System.out.println("异常通知AfterThrowing");
    }

    /*
    * 环绕通知
    * */
    @Around("logAop()")
    public void logAround(ProceedingJoinPoint jp){
        try {
            System.out.println("自定义前置通知Before");
            jp.proceed();//运行程序
            System.out.println("自定义后置通知after");

        } catch (Throwable throwable) {
            System.out.println("异常处理");
            throwable.printStackTrace();
        }
    }

}
