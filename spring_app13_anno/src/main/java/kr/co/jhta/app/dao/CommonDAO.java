package kr.co.jhta.app.dao;

import kr.co.jhta.app.dto.DeptDTO;

import java.sql.Connection;
import java.util.List;

public interface CommonDAO {
	public Connection connect();
	public List<DeptDTO> selectAll();
	public DeptDTO selectOne(int no);
	public void write(DeptDTO dto);
	public void modify(DeptDTO dto);
	public void drop(int no);
	public void close();
}
