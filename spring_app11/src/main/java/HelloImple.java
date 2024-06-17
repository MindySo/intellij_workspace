import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

// @Setter
public class HelloImple implements HelloInter {
	@Autowired
	NowTime nt;

	public void setNt(NowTime nt) {	// Lombok 사용
		this.nt = nt;
	}

	@Override
	public void sayHello() {
		
//		NowTime nt = new NowTime();
		
		int hour = nt.getHour();
		if(hour >= 6 && hour < 11) {
			System.out.println("안녕하세요.");
			
		} else if (hour >= 11 && hour < 16) {
			System.out.println("점심 식사하셨나요?");
			
		} else {
			System.out.println("좋은 저녁 되세요.");
		}
	}
}