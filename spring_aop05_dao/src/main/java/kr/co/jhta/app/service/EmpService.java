package kr.co.jhta.app.service;

import kr.co.jhta.app.dao.CommonDAO;
import kr.co.jhta.app.dto.EmpDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmpService implements DBService{

    @Autowired
    CommonDAO dao;

    public void setDao(CommonDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<EmpDTO> readAll() {
        dao.connect();
        List<EmpDTO> list = dao.selectAll();
        dao.close();
        return list;
    }

    @Override
    public EmpDTO readOne(int no) {
        dao.connect();
        EmpDTO dto = dao.selectOne(no);
        dao.close();
        return dto;
    }

    @Override
    public void write(EmpDTO dto) {
        dao.connect();
        dao.write(dto);
        dao.close();
    }

    @Override
    public void modify(EmpDTO dto) {
        dao.connect();
        dao.modify(dto);
        dao.close();
    }

    @Override
    public void drop(int no) {
        dao.connect();
        dao.drop(no);
        dao.close();
    }

}
