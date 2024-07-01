package kr.co.jhta.app.springbootex12.service;

import kr.co.jhta.app.springbootex12.dto.DeptDTO;

import java.util.List;

public interface DeptService {

    List<DeptDTO> readAll();

    void write(DeptDTO deptDTO);

    DeptDTO readOne(int no);

    void modify(int no, DeptDTO deptDTO);

    void remove(int no);
}
