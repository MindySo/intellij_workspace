package kr.co.jhta.app;

import java.util.List;
import java.util.ServiceConfigurationError;

import kr.co.jhta.app.dao.CommonDAO;
import kr.co.jhta.app.dto.DeptDTO;
import kr.co.jhta.app.service.DeptService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		
//		OracleDAO dao = new OracleDAO();
//		
//		Connection conn = dao.connect();
//		System.out.println("conn : " + conn);
//		
		ApplicationContext context = new ClassPathXmlApplicationContext("app.xml");

		DeptService service = context.getBean("service", DeptService.class);

		List<DeptDTO> list = service.readAll();
		for(DeptDTO dto : list) {
			System.out.println(dto);
		}

		System.out.println("============================");
		System.out.println("select test");

		DeptDTO dto10 = service.readOne(10);
		System.out.println(dto10);

		System.out.println("============================");
		System.out.println("update test");

		dto10.setDname("경영");
		dto10.setLoc("서울");

		service.modify(dto10);

		dto10 = service.readOne(10);
		System.out.println(dto10);

		System.out.println("============================");
		System.out.println("insert test");

		DeptDTO dto2 = new DeptDTO(98, "회계", "부산");
		service.write(dto2);

		System.out.println("============================");
		System.out.println("delete test");

		service.drop(98);
		DeptDTO dto98 = service.readOne(98);

		System.out.println("삭제되면 null : " + dto98);
	}
}
