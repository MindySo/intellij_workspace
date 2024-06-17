package kr.co.jhta.app.dao;

import kr.co.jhta.app.dto.DeptDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAO implements CommonDAO {

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
	public List<DeptDTO> selectAll(){
		sb.setLength(0);
		sb.append("SELECT deptno, dname, loc FROM dept");
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
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public DeptDTO selectOne(int no) {

		sb.setLength(0);
		sb.append("SELECT deptno, dname, loc FROM dept WHERE deptno = ?");
		DeptDTO dto = null;

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				dto = new DeptDTO(no, dname, loc);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public void write(DeptDTO dto) {
		sb.setLength(0);
		sb.append("INSERT INTO dept ");
		sb.append("VALUES (?, ?, ?)");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getDeptno());
			pstmt.setString(2, dto.getDname());
			pstmt.setString(3, dto.getLoc());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modify(DeptDTO dto) {
		sb.setLength(0);
		sb.append("UPDATE dept SET ");
		sb.append("dname = ? , loc = ?");
		sb.append("WHERE deptno = ?");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getLoc());
			pstmt.setString(2, dto.getDname());
			pstmt.setInt(3, dto.getDeptno());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void drop(int no) {
		sb.setLength(0);
		sb.append("DELETE FROM dept WHERE deptno = " + no);

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
