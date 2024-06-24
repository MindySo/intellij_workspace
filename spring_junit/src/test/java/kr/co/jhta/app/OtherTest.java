package kr.co.jhta.app;

import kr.co.jhta.dao.DeptDTO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;



public class OtherTest {

    @Test
    public void test1() {
        List<DeptDTO> list = new ArrayList<DeptDTO>();
        DeptDTO dto1 = new DeptDTO();
        dto1.setDeptno(99);
        dto1.setDname("AI");
        dto1.setLoc("Busan");

        DeptDTO dto2 = DeptDTO.builder().deptno(98).dname("IT").loc("서울").build();
        DeptDTO dto3 = DeptDTO.builder().deptno(97).dname("IT").loc("서울").build();
        DeptDTO dto4 = DeptDTO.builder().deptno(96).dname("경영").loc("울산").build();

        // dto1의 부서명이 AI가 맞는지 테스트
        assertThat(dto1.getDname()).isEqualTo("AI");

        // dto2의 부서위치가 서울이 맞는지 테스트
        assertThat(dto2.getLoc()).as("부서위치 : %s", dto2.getLoc()).isEqualTo("서울");

        list.add(dto1);
        list.add(dto2);
        list.add(dto3);
        list.add(dto4);

        // list의 사이즈가 2인지 테스트
        assertThat(list.size()).isEqualTo(4);
        assertThat(list).filteredOn(dto -> dto.getLoc().contains("산")).containsOnly(dto4);

    }
}
