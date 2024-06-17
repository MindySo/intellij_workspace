package kr.co.jhta.app;


import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTime implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("지금 시간 : HH : mm : ss");
        System.out.println(sdf.format(d));
    }
}
