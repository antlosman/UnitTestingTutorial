package org.example.junitdemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTest {

  @Test
  @Disabled("Don't run until JIRA #123 is resolved")
  void basicTest() {
    // execute method and perform asserts
  }

  @Test
  @EnabledOnOs(OS.WINDOWS)
  void testForWindowsOnly() {
    // execute method and perform asserts
  }

  @Test
  @EnabledOnOs(OS.MAC)
  void testForMacOnly() {
    // execute method and perform asserts
  }

  @Test
  @EnabledOnOs({OS.MAC, OS.WINDOWS})
  void testForWindowsAndMacOnly() {
    // execute method and perform asserts
  }

  @Test
  @EnabledOnJre(JRE.JAVA_17)
  void testForJava17Only() {
    // execute method and perform asserts
  }

  @Test
  @EnabledOnJre(JRE.JAVA_13)
  void testForJava13Only() {
    // execute method and perform asserts
  }

  @Test
  @EnabledForJreRange(min=JRE.JAVA_13, max = JRE.JAVA_17)
  void testForJava13TillJava17Only() {
    // execute method and perform asserts
  }

  @Test
  @EnabledForJreRange(min=JRE.JAVA_11)
  void testOnlyForJavaRangeMin() {
    // execute method and perform asserts
  }

  @Test
  @EnabledIfEnvironmentVariable(named = "LUV@CODE_ENV", matches = "DEV")
  void testOnlyForEnvironmentVariable() {
    // execute method and perform asserts
  }

  @Test
  @EnabledIfSystemProperty(named = "LUV2CODE_SYS_PROP", matches = "CI_CD_DEPLOY")
  void testOnlyForSystemProperty() {
    // execute method and perform asserts
  }



}
