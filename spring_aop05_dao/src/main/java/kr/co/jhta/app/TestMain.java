package kr.co.jhta.app;

import kr.co.jhta.app.dto.EmpDTO;
import kr.co.jhta.app.service.DBService;
import kr.co.jhta.app.service.EmpService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

        DBService service = context.getBean("service", DBService.class);

        List<EmpDTO> list = service.readAll();
        for(EmpDTO dto : list) {
            System.out.println(dto);
        }

        System.out.println("============================");
        System.out.println("select test");

        EmpDTO dto10 = service.readOne(10);
        System.out.println(dto10);

        System.out.println("============================");
        System.out.println("update test");

        dto10.setEname("someone");
        dto10.setJob("some job");

        service.modify(dto10);

        dto10 = service.readOne(10);
        System.out.println(dto10);

        System.out.println("============================");
        System.out.println("insert test");

        EmpDTO dto2 = new EmpDTO();
        service.write(dto2);

        System.out.println("============================");
        System.out.println("delete test");

        service.drop(98);
        EmpDTO dto98 = service.readOne(98);

        System.out.println("삭제되면 null : " + dto98);
    }
}
