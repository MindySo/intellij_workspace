package kr.co.jhta.web.util;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {
    public static Map<String, Object> getPageData(int totalNumber, int countPerPage, int currentPage) {
        Map<String, Object>map = new HashMap<String, Object>();

        // 총 페이지 수
        int totalPages = (totalNumber % countPerPage == 0)?totalNumber/countPerPage:totalNumber/countPerPage + 1;

        // 현재 페이지의 시작 번호, 끝번호
        int startNo = (currentPage - 1) * countPerPage + 1;
        int endNo = (currentPage) * countPerPage;

        // 페이지 nav에서 시작 페이지 번호
        int startPageNo = currentPage-5 <= 0 ? 1 : currentPage-5;

        // 페이지 nav에서 시작 페이지 번호
        int endPageNo = startPageNo+9 <= totalPages ? startPageNo+9 : totalPages;

        //이전, 다음
        boolean prev = startPageNo > 1;
        boolean next = endPageNo < totalPages-1;

        map.put("totalNumber", totalNumber);
        map.put("countPerPage", countPerPage);
        map.put("currentPage", currentPage);
        map.put("totalPages", totalPages);
        map.put("startNo", startNo);
        map.put("endNo", endNo);
        map.put("startPageNo", startPageNo);
        map.put("endPageNo", endPageNo);
        map.put("prev", prev);
        map.put("next", next);

        return map;

    }
}
