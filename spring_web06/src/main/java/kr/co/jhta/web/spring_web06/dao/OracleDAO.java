package kr.co.jhta.web.spring_web06.dao;

import java.sql.*;

public class OracleDAO implements CommonDAO{
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "scott";
    String password = "tiger";
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    StringBuffer sb = new StringBuffer();

    public OracleDAO() {
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

    @Override
    public boolean findByIdAndPw(String id, String pw) {
        sb.setLength(0);
        sb.append("select id, pw ");
        sb.append("from member ");
        sb.append("where id = ? and pw = ?");
        boolean result = false;

        try {
            pstmt = conn.prepareStatement(sb.toString());
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            result = rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
