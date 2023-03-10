package org.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FizzBuzzTest {

  // if number is divisible by 3, print Fizz
  // if number is divisible by 5, print Buzz
  // if number is divisible by 3 and 5, print FizzBuzz
  // if number is not divisible by 3 or 5, then print the number

  @Test
  @DisplayName("Divisible by Three")
  @Order(1)
  void testForDivisibleByThree() {

    String expected = "Fizz";

    assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
  }

  @Test
  @DisplayName("Divisible by Five")
  @Order(2)
  void testForDivisibleByFive() {

    String expected = "Buzz";

    assertEquals(expected, FizzBuzz.compute(10), "Should return Buzz");
  }

  @Test
  @DisplayName("Divisible by Three and Five")
  @Order(3)
  void testForDivisibleByThreeAndFive() {

    String expected = "FizzBuzz";

    assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
  }

  @Test
  @DisplayName("Not Divisible by Three and Five")
  @Order(4)
  void testForNotDivisibleByThreeAndFive() {

    String expected = "1";

    assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
  }

  @ParameterizedTest(name = "value={0}, expected={1}")
  @CsvFileSource(resources = "/small-test-data.csv")
  @DisplayName("Testing with small data file")
  @Order(5)
  void testSmallDataFile(int value, String expected) {

    /* Behind the scenes, JUnit will run the test multiple times and supply the data for the
    parameters.
     */

    assertEquals(expected, FizzBuzz.compute(value));

  }

  @ParameterizedTest(name = "value={0}, expected={1}")
  @CsvFileSource(resources = "/medium-test-data.csv")
  @DisplayName("Testing with medium data file")
  @Order(6)
  void testMediumDataFile(int value, String expected) {

    /* Behind the scenes, JUnit will run the test multiple times and supply the data for the
    parameters.
     */

    assertEquals(expected, FizzBuzz.compute(value));

  }

  @ParameterizedTest(name = "value={0}, expected={1}")
  @CsvFileSource(resources = "/large-test-data.csv")
  @DisplayName("Testing with large data file")
  @Order(7)
  void testLargeDataFile(int value, String expected) {

    /* Behind the scenes, JUnit will run the test multiple times and supply the data for the
    parameters.
     */

    assertEquals(expected, FizzBuzz.compute(value));

  }

}
