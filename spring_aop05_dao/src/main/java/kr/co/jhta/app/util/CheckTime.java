package kr.co.jhta.app.util;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class CheckTime  implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // 시간 측정기
        StopWatch stopWatch = new StopWatch();

        // 시간 측정 시작
        stopWatch.start();

        // 타겟의 메서드를 실행
        Object object = invocation.proceed();

        // 시간 측정 중지
        stopWatch.stop();

        System.out.println("메서드 실행시간 : " + stopWatch.getTotalTimeSeconds());

        return object;
    }
}
