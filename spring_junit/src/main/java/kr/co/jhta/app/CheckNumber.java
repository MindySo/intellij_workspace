package kr.co.jhta.app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CheckNumber {

    public  List<List<Character>> fileRead() {
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

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numList;
    }

    public boolean checkNum(List<Character> list) {
        List<Character> list2 = new ArrayList<>();
        list2.addAll(list);
        list.removeIf(c -> (c == ' ' || c == '-'));

        boolean result = false;

        if(list.size() == 13){
            int sum = 0;
            for(int i = 0 ; i < 12 ; i++){
                if(i <= 7){
                    sum += (i+2) * Character.getNumericValue(list.get(i));
                } else {
                    sum += (i-6) * Character.getNumericValue(list.get(i));
                }
            }
            int cn = 11-(sum%11);

            if(cn == Character.getNumericValue(list.get(12))){
                System.out.print("입력값 : [");
                list2.forEach(System.out::print);
                System.out.println("]는 주민번호가 맞습니다.");

                result = true;
            }else{
                System.out.print("입력값 : [");
                list2.forEach(System.out::print);
                System.out.println("]는 개인정보가 아닙니다.");

                result = false;
            }
        } else if (list.size() == 16) {
            int cnt = 0;
            for(int i = 0 ; i < 16 ; i++){
                if(Character.getNumericValue(list.get(i)) >= 10){
                    cnt++;
                }
            }
            if(cnt == 0){
                System.out.print("입력값 : [");
                list2.forEach(System.out::print);
                System.out.println("]는 카드번호가 맞습니다.");

                result = true;
            }else{
                System.out.print("입력값 : [");
                list2.forEach(System.out::print);
                System.out.println("]는 개인정보가 아닙니다.");

                result = false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CheckNumber p = new CheckNumber();
        List<List<Character>> numList = p.fileRead();

        for(int i = 0 ; i < numList.size() ; i++) {
            p.checkNum(numList.get(i));
        }
    }
}
