package com.joker.aops;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BuyAspect {


    @Pointcut("execution(* com.joker.aops.IBuy.buy(..))")
    public void point(){}


//    @Before("point()")
////    @Before("execution(* com.joker.aops.IBuy.buy(..))")
//    public void  haha(){
//        System.out.println("男孩子女孩子都买了自己喜欢的东西 --Before");
//    }

//    @Before("execution(* com.joker.aops.IBuy.buy(..)) && within(com.joker.aops.*) && bean(girl) ")
//    public void  haha(){
//        System.out.println("女孩子都买了自己喜欢的东西");
//    }

////    @After("execution(* com.joker.aops.IBuy.buy(..))")
//    @After("point()")
//    public void hehe(){
//        System.out.println("方法返回后 -- 男孩女孩都花光了积蓄 --After");
//    }


//    @AfterReturning("execution(* com.joker.aops.IBuy.buy(..))")
//    public void xixi(){
//        System.out.println("目标方法返回后调用  --AfterReturning");
//    }


//    @AfterThrowing("execution(* com.joker.aops.IBuy.buy(..))")
//    public void ouou(){
//        System.out.println("目标方法抛出异常后调用  --AfterThrowing");
//
//    }

////    @Around("execution(* com.joker.aops.IBuy.buy(..))")
//    @Around("point()")
//    public void pupu(ProceedingJoinPoint pj){
//
//        try {
//            System.out.println("环绕执行--AAAA");
//            pj.proceed();
//            System.out.println("环绕执行--BBBB");
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//
//    }

    @Pointcut("execution(* com.joker.aops.IBuy.buy(double )) && bean(girl) && args(price)")
    public void gif(double price){}

    @Around("gif(price)")
    public String xxx(ProceedingJoinPoint pj,double price){
        try {
            pj.proceed();
            if(price>68){
                System.out.println("女孩买衣服超过了68元，赠送一双袜子");
                return "衣服和袜子";
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "衣服";
    }











    public void hehe() {
        System.out.println("before ...");
    }

    public void haha() {
        System.out.println("After ...");
    }

    public void xixi() {
        System.out.println("AfterReturning ...");
    }

    public void xxx(ProceedingJoinPoint pj) {
        try {
            System.out.println("Around aaa ...");
            pj.proceed();
            System.out.println("Around bbb ...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    public String heha(ProceedingJoinPoint pj, double price){
        try {
            pj.proceed();
            if (price > 68) {
                System.out.println("女孩买衣服超过了68元，赠送一双袜子");
                return "衣服和袜子";
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return "衣服";
    }

}
