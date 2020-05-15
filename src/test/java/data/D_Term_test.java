package test.java.data;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import main.java.data.D_Term;

public class D_Term_test {

  @Test
  public void term_withoutArgs() {
    // setup
    D_Term term = D_Term.create("Foo");

    // test
    String s = term.toString();

    // validate
    assertEquals("Foo{}", s);
  }

}
