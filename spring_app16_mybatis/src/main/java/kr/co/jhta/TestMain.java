package kr.co.jhta;

import kr.co.jhta.dao.ConnectionManager;
import kr.co.jhta.dao.Dao;
import kr.co.jhta.dao.DeptDAO;
import kr.co.jhta.dto.DeptDTO;
import org.springframework.cglib.proxy.Factory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {

        ApplicationContext ac = new ClassPathXmlApplicationContext("app.xml");
        Dao d = ac.getBean("dao", Dao.class);
        d.selectAll().forEach(System.out::println);

        System.out.println("---------------------------------");
        List<DeptDTO> list = d.selectAll();
        for(DeptDTO dto1 : list) {
            System.out.println(dto1);
        }

        System.out.println("---------------------------------");
        DeptDTO deptDTO = d.selectOne(10);
        System.out.println(deptDTO);

        System.out.println("---------------------------------");
        DeptDTO dto2 = new DeptDTO();
        dto2.setDeptno(10);
        dto2.setDname("AI");
        dto2.setLoc("용인");
        d.update(dto2);

        deptDTO = d.selectOne(10);
        System.out.println(deptDTO);


    }
}
