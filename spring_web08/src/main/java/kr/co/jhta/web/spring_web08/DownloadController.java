package kr.co.jhta.web.spring_web08;

import com.google.protobuf.compiler.PluginProtos;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/download")
public class DownloadController extends HttpServlet {

    final String filepath = "/data";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n = req.getParameter("no");
        int no = 0;
        if(n != null) {
            no = Integer.parseInt(n);

            FileDAO dao = new FileDAO();
            FileDTO dto = dao.selectOne(no);
            String path = getServletContext().getRealPath("/data");
            File downloadFile = new File(path +"/"+ dto.getFilePath());

            FileInputStream fis = new FileInputStream(downloadFile);
            String mimeType = getServletContext().getMimeType(downloadFile.getAbsolutePath());

            if(mimeType == null){
                mimeType = "application/octet-stream";
            }

            // 사용자 브라우저에 내가 보내는건 파일이야..
            resp.setContentType(mimeType);
            resp.setContentLength((int)downloadFile.length());

            //응답 헤더 설정
            String header = "context-Disposition: attachment; filename=\"" + downloadFile.getName();
            resp.setHeader("Content-Disposition", header);

            // 파일 내용을 응답으로 전송
            OutputStream os = resp.getOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1; // 1바이트 전송 -1 초기값
            while((bytesRead = fis.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            fis.close();
            os.close();
        }
    }
}
