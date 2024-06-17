package kr.co.jhta.app.dao;

import kr.co.jhta.app.dto.EmpDTO;

import java.sql.Connection;
import java.util.List;

public interface CommonDAO {
    public Connection connect();
    public List<EmpDTO> selectAll();
    public EmpDTO selectOne(int no);
    public void write(EmpDTO dto);
    public void modify(EmpDTO dto);
    public void drop(int no);
    public void close();
}
