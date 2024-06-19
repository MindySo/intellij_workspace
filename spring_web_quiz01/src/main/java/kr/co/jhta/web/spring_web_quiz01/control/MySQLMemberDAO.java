package kr.co.jhta.web.spring_web_quiz01.control;

import java.sql.*;

public class MySQLMemberDAO implements CommonDAO{

    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/xe";
    String user = "scott";
    String password = "tiger";
    Connection conn;
    PreparedStatement pstmt;
    ResultSet rs;
    StringBuffer sb = new StringBuffer();

    public MySQLMemberDAO() {
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

    @Override
    public boolean insertOne(MemberDTO dto) {
        sb.setLength(0);
        sb.append("insert into member (no, id, name, pw, motive) ");
        sb.append("values (null, ?, ?, ?, ?)");
        boolean result = false;

        try {
            pstmt = conn.prepareStatement(sb.toString());
            pstmt.setString(1, dto.getId());
            pstmt.setString(2, dto.getName());
            pstmt.setString(3, dto.getPw());
            pstmt.setString(4, dto.getMotive());
            rs = pstmt.executeQuery();
            result = rs.next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
