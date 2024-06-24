package kr.co.jhta.app;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CheckNumTest {

    @Test
    public void checknum(){
        CheckNumber cn = new CheckNumber();
        List<Character> num = new ArrayList<>();
        List<List<Character>> numList = new ArrayList<>();

        try(FileReader fr = new FileReader("D:\\dev\\log\\info.txt")){
            char[] ch = new char[1000];
            fr.read(ch);
            ch = new String(ch).trim().toCharArray();

            for (char c : ch) {
                if (c != '\n' && c != '\r') {
                    num.add(c);
                } else if(num.size() != 0){
                    numList.add(num);
                    num = new ArrayList<>();
                }
            }
            numList.add(num);

            cn.checkNum(numList.get(4));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
