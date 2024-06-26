package kr.co.jhta.app.springex07.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeptDTO {
    public int deptno;
    public String dname;
    public String loc;
}
