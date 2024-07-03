package kr.co.jhta.app.springbootex13.test;

import org.mockito.Mockito;
import java.util.List;


public class test2 {
    public static void main(String[] args) {
        List<String> list = Mockito.mock(List.class);
        Mockito.when(list.get(0)).thenReturn("포도");

        //메서드 호출
        list.get(0);
        Mockito.verify(list).get(0);

    }
}
