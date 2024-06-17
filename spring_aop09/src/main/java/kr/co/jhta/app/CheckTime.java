package kr.co.jhta.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;

@Aspect
public class CheckTime {
    @Pointcut("execution(public void fire(..))")
    public void publicTarget() {}

    @Around("publicTarget()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String name = joinPoint.getSignature().getName();
        System.out.println("실행중인 메서드 : " + name);
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();
        System.out.println("실행시간 : " + stopWatch.getTotalTimeSeconds());

        return result;
    }
}
