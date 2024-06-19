package kr.co.jhta.web.spring_web07.dao;

import kr.co.jhta.web.spring_web07.dto.DeptDTO;
import kr.co.jhta.web.spring_web07.dto.MemberDTO;

import java.util.List;

public interface CommonDAO {
    public boolean findByIdAndPw(String id, String pw);
    public boolean insertOne(MemberDTO dto);
    public List<DeptDTO> selectDeptList();
}
