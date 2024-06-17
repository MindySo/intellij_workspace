package kr.co.jhta.app.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class CheckTime {
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();

        System.out.println("methodName = " + methodName);

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object object = pjp.proceed();
        stopWatch.stop();

        System.out.println("메서드 실행시간 : " + stopWatch.getTotalTimeSeconds());

        return object;
    }
}
