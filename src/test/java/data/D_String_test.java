package test.java.data;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.data.D_String;

public class D_String_test {

  private String _unescaped = "\" \\ \b \f \n \r \t";
  private String _escaped = "\\\" \\\\ \\b \\f \\n \\r \\t";

  @Test
  public void escapify_escapesControlCharacters() {
    // setup
    D_String str = D_String.create(_unescaped);

    // test
    String s1 = str.escapify();

    // validate
    assertEquals(_escaped, s1);
  }

  @Test
  public void unescapify_unescapesControlCharacters() {
    // setup
    D_String str = D_String.create(_escaped);

    // test
    String s1 = str.unescapify();

    // validate
    assertEquals(_unescaped, s1);
  }

}
