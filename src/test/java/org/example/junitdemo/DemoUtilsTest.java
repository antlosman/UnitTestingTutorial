package org.example.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Multiply")
    void testMultiply() {

        assertEquals(12, demoUtils.multiply(4,3), "4*3 must be 12");
        assertNotEquals(12, demoUtils.multiply(5,2), "5*2 must not be 12");
    }

    @Test
    @DisplayName("Same and Not Same")
    void testSameAndNotSame() {

        String str = "testString";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(),
                "Object should refer to the same object");

        assertNotSame(str, demoUtils.getAcademy(), "Objects should not refer to same object");
    }

    @Test
    @DisplayName("True or False")
    void testTrueFalse() {

        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo), "This should be true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne), "This should return false");

    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {

        String[] stringArray = {"A", "B", "C"};

        assertArrayEquals(stringArray, demoUtils.getFirstThreeLettersOfAlphabet(), "Array should be the same");
    }

    @Test
    @DisplayName("Iterable equals")
    void testIterableEquals() {

        List<String> theList = List.of("luv", "2", "code");

        assertIterableEquals(theList, demoUtils.getAcademyInList(),
                "Expected list should be same as actual list");
    }

    @Test
    @DisplayName("Lines match")
    void testLinesMatch() {

        List<String> theList = List.of("luv", "2", "code");

        assertLinesMatch(theList, demoUtils.getAcademyInList(), "Lines should match");

    }

    @Test
    @DisplayName("Throws and Does Not Throw")
    void testThrowsAndDoesNotThrow() {

        assertThrows(Exception.class, () -> { demoUtils.throwException(-1); }, "Should throw exception");

        assertDoesNotThrow(() -> { demoUtils.throwException(5); }, "Should not throw exception");

    }

    @Test
    @DisplayName("Timeout")
    void testTimeout() {

        assertTimeoutPreemptively(Duration.ofSeconds(3), () -> { demoUtils.checkTimeout(); },
                "Method should execute in 3 seconds");

    }

//    @AfterEach
//    void setupAfterEach() {
//        System.out.println("Running @AfterEach");
//        System.out.println();
//    }
//
//    @BeforeAll
//    static void setupBeforeEachClass() {
//        System.out.println("@BeforeAll executes only once before all test methods execution in the class");
//    }
//
//    @AfterAll
//    static void tearDownAfterAll() {
//        System.out.println("@AfterAll executes only once after all test methods execution in the class");
//    }

    @Test
    @DisplayName("Equals and Not Equals")
    @Order(1)
    void testEqualsAndNotEquals() {

        System.out.println("Running test: testEqualsAndNotEquals");

        assertEquals(6, demoUtils.add(2, 4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    @DisplayName("Null and Not Null")
    @Order(0)
    void testNullAndNotNull() {

        System.out.println("Running test: testNullAndNotNull");

        String str1 = null;
        String str2 = "test";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }
}
