package kr.co.jhta.dao;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;


public class OracleDAO{
    String driver = "oracle.jdbc.driver.OracleDriver";
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "scott";
    String password = "tiger";
    Connection conn ;
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

    public boolean findByIdAndPw(String id, String pw) {
        sb.setLength(0);
        sb.append("select id, pw ");
        sb.append("from member ");
        sb.append("where id = ?  and pw = ?");
        boolean result = false; // 무조건 일단 없음

        try {
            pstmt = conn.prepareStatement(sb.toString());
            pstmt.setString(1, id);
            pstmt.setString(2, pw);
            rs = pstmt.executeQuery();
            result = rs.next(); // 다음 값이 존재하면 true , 없으면 false

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<DeptDTO> selectList() {
        sb.setLength(0);
        sb.append("select * from dept ");
        ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
        try {
            pstmt = conn.prepareStatement(sb.toString());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                DeptDTO dto = new DeptDTO(deptno, dname, loc);
                list.add(dto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}