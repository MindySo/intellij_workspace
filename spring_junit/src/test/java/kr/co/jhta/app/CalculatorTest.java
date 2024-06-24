package kr.co.jhta.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
    }

    @Test
    void sum() {
        assertEquals(300, cal.sum(100, 200));
    }

    @Test
    void minus() {
        assertEquals(100, cal.minus(200, 100));
    }

    @Test
    void multi() {
        assertEquals(100, cal.multi(2, 50));

        assertThat(cal.multi(2, 50)).isEqualTo(100);

        // method chaining 지원, 좀 더 깔끔하고 읽기 쉬운 테스트 코드 작성
    }

    @Test
    void test_assertThat(){
        assertThat("Hello, World! Today is monday.")
                .isNotEmpty()
                .contains("Hello, World!")
                .contains("Today is monday.")
                .doesNotContain("sunday")
                .startsWith("Hell")
                .endsWith(".")
                .isEqualTo("Hello, World! Today is monday.");
    }

    @Test
    void test_assertThatNumber() {
        assertThat(3.14159265358979323846)
                .isPositive()
                .isNotNegative()
                .isGreaterThan(3)
                .isLessThan(4)
                .isBetween(3.1d, 3.2d)
                .isEqualTo(3.14159265358979323846);
    }
}