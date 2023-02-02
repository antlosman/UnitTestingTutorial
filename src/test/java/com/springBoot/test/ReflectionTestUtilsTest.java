package com.springBoot.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.springBoot.component.MvcTestingExampleApplication;
import com.springBoot.component.models.CollegeStudent;
import com.springBoot.component.models.StudentGrades;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ReflectionTestUtilsTest {

  @Autowired
  ApplicationContext context;

  @Autowired
  CollegeStudent studentOne;

  @Autowired
  StudentGrades studentGrades;

  @BeforeEach
  public void studentBeforeEach() {
    studentOne.setFirstname("Eric");
    studentOne.setLastname("Roby");
    studentOne.setEmailAddress("eric.roby@gmail.com");
    studentOne.setStudentGrades(studentGrades);

    // set private field directly
    ReflectionTestUtils.setField(studentOne, "id", 1);
    ReflectionTestUtils.setField(studentOne, "studentGrades",
        new StudentGrades(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.50))));
  }

  @Test
  public void getPrivateFields() {
    assertEquals(1, ReflectionTestUtils.getField(studentOne, "id"));
  }

  @Test
  public void invokePrivateMethod() {
    assertEquals("Eric 1",
        ReflectionTestUtils.invokeMethod(studentOne, "getFirstNameAndId"),
        "Fail private method not call");
  }

}
