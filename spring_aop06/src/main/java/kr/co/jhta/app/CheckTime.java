package kr.co.jhta.app;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class CheckTime implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch stopWatch = new StopWatch();

        stopWatch.start();

        Object result = invocation.proceed();

        stopWatch.stop();

        System.out.println("실행시간 : " + stopWatch.getTotalTimeSeconds());

        return result;
    }
}
