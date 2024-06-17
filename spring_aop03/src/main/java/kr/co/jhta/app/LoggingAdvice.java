package kr.co.jhta.app;

// transfer 메서드가 호출되면 기록을 남기기
// d:\dev\log\log20240614.txt 파일을 생성
// 2024년 6월 14일 15시 30분에 이체함

import org.springframework.aop.AfterReturningAdvice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        makeLog();
        System.out.println("로그 파일 생성됨");
    }

    private void makeLog() {
        Date now = new Date();
        SimpleDateFormat sdfTitle = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat sdfContent = new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");

        String title = sdfTitle.format(now);
        String content = sdfContent.format(now);

        File f = new File("d:\\dev\\log\\log" + title + ".txt");
        try {
            if (!f.exists()) {
                f.createNewFile();
            }
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(content + "에 이체함");

            fw.flush();

            pw.close();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
