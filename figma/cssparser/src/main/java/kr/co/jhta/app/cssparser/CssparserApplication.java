package kr.co.jhta.app.cssparser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CssparserApplication {

    public static void main(String[] args) {
        String dir = "D:\\aibayo_figma\\html\\";
        String htmlname = "admin_smj";
        String cssname = htmlname;

        try {
            // HTML 파일 읽기
            File input = new File(dir + htmlname + ".html");
            Document doc = Jsoup.parse(input, "UTF-8");

            // 같은 스타일을 찾기
            Map<String, String> styles = new HashMap<>();
            int classCounter = 1;

            Elements elements = doc.select("[style]");
            for (Element element : elements) {
                String style = element.attr("style");
                if (!styles.containsKey(style)) {
                    String className = "class_" + classCounter++;
                    styles.put(style, className);
                }
                element.addClass(styles.get(style));
                element.removeAttr("style");
            }

            // 새로운 CSS 파일 생성
            FileWriter cssWriter = new FileWriter(dir + "result\\" + cssname + ".css");
            for (Map.Entry<String, String> entry : styles.entrySet()) {
                cssWriter.write("." + entry.getValue() + " { " + entry.getKey() + " }\n");
            }
            cssWriter.close();

            // 수정된 HTML 파일 저장
            FileWriter htmlWriter = new FileWriter(dir + "result\\" + htmlname + ".html");
            htmlWriter.write(doc.outerHtml());
            htmlWriter.close();

            System.out.println("CSS 파일과 HTML 파일이 성공적으로 생성되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
