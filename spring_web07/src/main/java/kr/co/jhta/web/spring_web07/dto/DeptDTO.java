package kr.co.jhta.web.spring_web07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptDTO {
    public int deptno;
    public String dname;
    public String loc;
}
