package test.java.i18n;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.i18n.Strings;

public class Strings_test {

  @Test
  public void get_withExistingString_returnsNewString() {
    // test
    String s = Strings.get("D_Array");

    // validate
    assertEquals("Array", s);
  }

  @Test
  public void get_withMissingString_returnsSameString() {
    // test
    String s = Strings.get("Xyzzy");

    // validate
    assertEquals("Xyzzy", s);
  }

}
