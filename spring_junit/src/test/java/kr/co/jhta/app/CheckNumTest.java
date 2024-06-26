package kr.co.jhta.app;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class CheckNumTest {

    @Test
    public void checknum(){
        CheckNumber cn = new CheckNumber();
        List<Character> num = new ArrayList<>();
        List<List<Character>> numList = cn.fileRead();

        assertThat(cn.checkNum(numList.get(4))).isEqualTo(true);
    }
}
