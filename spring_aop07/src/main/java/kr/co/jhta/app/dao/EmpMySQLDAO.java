package kr.co.jhta.app.dao;

import kr.co.jhta.app.dto.EmpDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpMySQLDAO implements CommonDAO{
    // 멤버변수
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/xe";
    String user = "scott";
    String password = "tiger";
    Connection conn;

    PreparedStatement pstmt = null;
    ResultSet rs = null;
    StringBuffer sb = new StringBuffer();

    // connect()
    @Override
    public Connection connect() {

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // 전체조회
    @Override
    public List<EmpDTO> selectAll(){
        sb.setLength(0);
        sb.append("SELECT empno, ename, job FROM emp");
        ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();

        try {
            pstmt = conn.prepareStatement(sb.toString());
            rs = pstmt.executeQuery();
            while(rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                EmpDTO dto = new EmpDTO(empno, ename, job);
                list.add(dto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public EmpDTO selectOne(int no) {

        sb.setLength(0);
        sb.append("SELECT empno, ename, job FROM emp WHERE empno = ?");
        EmpDTO dto = null;

        try {
            pstmt = conn.prepareStatement(sb.toString());
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                dto = new EmpDTO();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dto;
    }

    @Override
    public void write(EmpDTO dto) {
        sb.setLength(0);
        sb.append("INSERT INTO emp ");
        sb.append("VALUES (?, ?, ?)");

        try {
            pstmt = conn.prepareStatement(sb.toString());
            pstmt.setInt(1, dto.getEmpno());
            pstmt.setString(2, dto.getEname());
            pstmt.setString(3, dto.getJob());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void modify(EmpDTO dto) {
        sb.setLength(0);
        sb.append("UPDATE emp SET ");
        sb.append("ename = ? , job = ?");
        sb.append("WHERE empno = ?");

        try {
            pstmt = conn.prepareStatement(sb.toString());
            pstmt.setString(1, dto.getEname());
            pstmt.setString(2, dto.getJob());
            pstmt.setInt(3, dto.getEmpno());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void drop(int no) {
        sb.setLength(0);
        sb.append("DELETE FROM emp WHERE empno = " + no);

        try {
            pstmt = conn.prepareStatement(sb.toString());
            int result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
