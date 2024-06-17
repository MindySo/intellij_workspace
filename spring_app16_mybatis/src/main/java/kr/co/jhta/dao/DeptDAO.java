package kr.co.jhta.dao;

import kr.co.jhta.dto.DeptDTO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DeptDAO implements Dao{
    ConnectionManager cm;

    public void setCm(ConnectionManager cm) {
        this.cm = cm;
    }

    @Override
    public List<DeptDTO> selectAll() {
        return ConnectionManager.factory
                                .openSession(true)
                                .selectList("kr.co.jhta.dept.selectAll");
    }

    @Override
    public DeptDTO selectOne(int no) {
        return ConnectionManager.factory
                .openSession(true)
                .selectOne("kr.co.jhta.dept.selectOne", no);
    }

    @Override
    public void insert(DeptDTO dto) {

    }

    @Override
    public void update(DeptDTO dto) {
        ConnectionManager.factory
                .openSession(true)
                .update("kr.co.jhta.dept.update", dto);
    }

    @Override
    public void delete(int no) {

    }
}
