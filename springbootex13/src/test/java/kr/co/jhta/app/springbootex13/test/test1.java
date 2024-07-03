package kr.co.jhta.app.springbootex13.test;

import java.util.List;

import static java.lang.Math.random;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class test1 {
    public static void main(String[] args) {
        // Mock 객체 : 테스트 시나리오에서 특정 객체의 행위를 흉내내는 객체

        // 여러 프레임워크를 통해 mock 객체를 쉽게 만들 수 있다.
        // Mock framework
        // Mockito, EasyMock, JMockit, ...

        // static으로 선언하면(math.random) 단독으로 쓸수 있음
        random();

        // Mockito.mock을 static으로 선언하여 사용
        List<String> list = mock(List.class);
        when(list.size()).thenReturn(3);

        System.out.println(list.size());

    }
}
