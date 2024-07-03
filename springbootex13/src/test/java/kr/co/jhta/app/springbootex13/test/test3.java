package kr.co.jhta.app.springbootex13.test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class test3 {
    public static void main(String[] args) {
        List<String> list = mock(List.class);
        when(list.get(anyInt())).thenThrow(new IndexOutOfBoundsException());

        try{
            list.get(9);
        }catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
