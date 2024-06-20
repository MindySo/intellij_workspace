package kr.co.jhta.web.spring_web08;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FileDAO {
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "scott";
    String password = "tiger";
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    StringBuffer sb = new StringBuffer();

    public FileDAO() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("conn : " + conn);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insert(String fileName){
        sb.setLength(0);
        sb.append("insert into uploadfile (no, filepath) ");
        sb.append("values (UPLOADFILE_NO_SEQ.nextval, ?)");
        try {
            pstmt = conn.prepareStatement(sb.toString());
            pstmt.setString(1, fileName);
            rs = pstmt.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public FileDTO selectOne(int no){
        sb.setLength(0);
        sb.append("select filepath from uploadfile ");
        sb.append("where no = ?");
        FileDTO dto = null;
        try {
            pstmt = conn.prepareStatement(sb.toString());
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();

            while(rs.next()) {
                String filepath = rs.getString("filepath");
                dto = new FileDTO(no, filepath);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    public List<FileDTO> selectAll(){
        sb.setLength(0);
        sb.append("select no, filepath from uploadfile");
        List<FileDTO> list = new ArrayList<>();
        try {
            pstmt = conn.prepareStatement(sb.toString());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int no = rs.getInt("no");
                String filepath = rs.getString("filepath");
                FileDTO dto = new FileDTO(no, filepath);
                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}
