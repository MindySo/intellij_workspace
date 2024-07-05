package kr.co.jhta.app.springbootex16;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestMain {
        // 정규표현식
        // 특정한 규칙을 가진 문자열의 집합을 표현하는데 사용하는 형식 언어

        // 언어, 텍스트편집기 문자열의 검색, 치환을 위해 지원
        // 자바, 자바스크립트 ==> 정규표현식
    public static void main(String[] args) {
        String searchData = "hongGilDong 20 남원_한양 hong@gmail.com 02-1234-5678"+
                            "KS 20 서울 dagda@hanafos.com 010-222-3333"+
                            "이순신 20 부산 lee@gmail.com 080 3333 4444 $5,000.50";

        // 특정 문자 : Gil(대소문자 구분)
        // 숫자 : d(decimal)
        // 문자 : w(word) : _포함한 문자열을 의미(한글제외)A~Z, a~z, 0~9, ...)
        // * : 0번 이상 반복 : 0, 1, n
        // + : 1번 이상 반복 : 1, n
        // ? : 0 or 1
        // {} : 횟수를 표시
        // 문장종결 $
        // 대문자로 된 여러글자를 얻어오기
        // . : 문자 1개를 의미

        // 검색 패턴 - 전화번호
//        Pattern pattern = Pattern.compile("\\d{3}-\\d{3}-\\d{3}");

        // 검색 패턴 - 이메일
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_\\-\\.]+@+[a-zA-Z0-9_\\-\\.]+\\.+[a-zA-Z0-9_]{2,}");

        // 검색할 문자열
        Matcher matcher = pattern.matcher(searchData);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
