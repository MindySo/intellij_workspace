package kr.co.jhta.app;

import kr.co.jhta.dao.DeptDTO;
import kr.co.jhta.dao.OracleDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


public class OracleDAOTest {
    OracleDAO dao;

    @BeforeEach
    public void setUp() {
        dao = new OracleDAO();
    }

    @AfterEach
    public void tearDown() {
        dao = null;
    }

    @Test
    void findByIdAndPw(){
        boolean result = dao.findByIdAndPw("aaa", "bbb");
        assertTrue(result);
    }

//    @Test
//    void selectList(){
////        assertEquals(22, dao.selectList().size());
//        assertThat(dao.selectList().size()).isEqualTo(22);
//        DeptDTO dto = dao.selectList().get(0);
//        assertThat(dto.getDeptno()).as("부서명 %s", dto.getDname()).isEqualTo(10);
//    }
}
