package kr.co.jhta.web.spring_web08;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@MultipartConfig
@WebServlet("/uploadOk.do")
public class MultipartServlet extends HttpServlet {

    final String UPLOAD_DIRECTORY = "/data";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // /data 파일 저장 디렉토리
        String realpath = getServletContext().getRealPath(UPLOAD_DIRECTORY);
        System.out.println("파일 저장경로" + realpath);

        File file = new File(realpath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 해당 디렉토리가 존재
        String msg = req.getParameter("msg");
        System.out.println("전달한 파라미터값 : " + msg);

        // 나머지는 파일
        for( Part part : req.getParts()){

            // 정확한 파일의 이름을 찾기
            String fileName = getFileName(part);
            System.out.println("파일명" + fileName);
            if(fileName != null) {
                part.write(realpath + File.separator + fileName);
            }
        }

    }

    private String getFileName(Part part) {
        for(String content : part.getHeader("content-disposition").split(";")){
            if(content.trim().startsWith("filename")) {
                content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return null;
    }
}
