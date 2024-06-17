package kr.co.jhta.app;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class CheckTime2 {
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        // 실행중인 메서드의 이름을 알아오기
        String methodName = pjp.getSignature().getName();

        // 출력
        System.out.println("methodName = " + methodName);

        // 시간 측정
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = pjp.proceed();
        stopWatch.stop();
        System.out.println("처리시간 : " + stopWatch.getTotalTimeSeconds());

        return result;
    }
}
