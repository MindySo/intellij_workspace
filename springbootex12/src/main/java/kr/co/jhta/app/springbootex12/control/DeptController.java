package kr.co.jhta.app.springbootex12.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.co.jhta.app.springbootex12.dto.DeptDTO;
import kr.co.jhta.app.springbootex12.service.DeptService;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.service.OperationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "예제 API", description = "SWAGGER 테스트용 API")

@RestController
@RequiredArgsConstructor
public class DeptController {
    private final DeptService deptService;

    // SELECT
    @Operation(summary = "전체조회", description = "부서의 목록을 확인합니다.", tags = "Dept Controller")
    @ApiResponse(responseCode = "200", description = "정상처리")
    @ApiResponse(responseCode = "404", description = "찾을 수 없음")
    @ApiResponse(responseCode = "500", description = "서버 에러")

    @GetMapping("/dept")

    public ResponseEntity<List<DeptDTO>> dept(Model model) {
        List<DeptDTO> list = deptService.readAll();
        model.addAttribute("list", list);
        return ResponseEntity.ok().body(list);
    }



    // SELECT
    @Operation(summary = "특정 부서 정보조회", description = "주어진 부서의 정보를 확인합니다.", tags = "Dept Controller")
    @Parameter(name = "deptno", description = "검색하고자 하는 부서번호를 입력하세요", required = true, example = "1")
    @ApiResponse(responseCode = "200", description = "정상처리")
    @ApiResponse(responseCode = "404", description = "찾을 수 없음")
    @ApiResponse(responseCode = "500", description = "서버 에러")

    @GetMapping("/dept/{deptno}")
    public ResponseEntity<DeptDTO> getOne(@PathVariable int deptno) {
        DeptDTO dto = deptService.readOne(deptno);
        return ResponseEntity.ok().body(dto);
    }



    // insert
    @Operation(summary = "부서정보 추가", description = "1개의 부서정보를 입력합니다.", tags = "Dept Controller")
    @Parameter(name = "dto", description = "부서정보")
    @ApiResponse(responseCode = "200", description = "정상처리", content = {@Content(schema = @Schema(implementation = DeptDTO.class))})
    @ApiResponse(responseCode = "404", description = "찾을 수 없음")
    @ApiResponse(responseCode = "500", description = "서버 에러")

    @PostMapping("/dept")
    public ResponseEntity<DeptDTO> WriteOne(@ModelAttribute DeptDTO deptDTO) {
        deptService.write(deptDTO);
        return ResponseEntity.ok().body(deptDTO);
    }


    // update
    @Operation(summary = "부서정보 수정", description = "주어진 부서의 정보를 수정합니다.", tags = "Dept Controller")
    @Parameter(name = "dto", description = "부서정보")
    @Parameter(name = "no", description = "부서번호")
    @ApiResponse(responseCode = "200", description = "정상처리", content = {@Content(schema = @Schema(implementation = DeptDTO.class))})
    @ApiResponse(responseCode = "404", description = "찾을 수 없음")
    @ApiResponse(responseCode = "500", description = "서버 에러")

    @PutMapping("/dept/{no}")
    public DeptDTO UpdateOne(@PathVariable int no, @ModelAttribute DeptDTO deptDTO) {
        deptService.modify(no, deptDTO);
        return deptDTO;
    }


    // delete
    @Operation(summary = "부서 삭제", description = "부서를 삭제합니다.", tags = "Dept Controller")
    @Parameter(name = "no", description = "부서번호")
    @ApiResponse(responseCode = "200", description = "정상처리", content = {@Content(schema = @Schema(implementation = DeptDTO.class))})
    @ApiResponse(responseCode = "404", description = "찾을 수 없음")
    @ApiResponse(responseCode = "500", description = "서버 에러")
    
    @DeleteMapping("/dept/{no}")
    public String delete(@PathVariable int no) {
        deptService.remove(no);
        return "OK";
    }

}
