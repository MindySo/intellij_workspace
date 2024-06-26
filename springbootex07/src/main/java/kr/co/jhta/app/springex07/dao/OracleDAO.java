package kr.co.jhta.app.springex07.dao;

import kr.co.jhta.app.springex07.dto.DeptDTO;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OracleDAO{
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

    public List<DeptDTO> selectDeptList() {
        sb.setLength(0);
        sb.append("select deptno, dname, loc ");
        sb.append("from dept");

        List<DeptDTO> list = new ArrayList<DeptDTO>();

        try {
            pstmt = conn.prepareStatement(sb.toString());
            rs = pstmt.executeQuery();
            while(rs.next()){
                int deptno = rs.getInt("deptno");
                String dname = rs.getString("dname");
                String loc = rs.getString("loc");
                DeptDTO dept = new DeptDTO(deptno, dname, loc);
                list.add(dept);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
