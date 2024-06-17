package kr.co.jhta.dao;

import kr.co.jhta.dto.DeptDTO;

import java.util.List;

public interface Dao {
    public List<DeptDTO> selectAll();
    public DeptDTO selectOne(int no);
    public void insert(DeptDTO dto);
    public void update(DeptDTO dto);
    public void delete(int no);
}
