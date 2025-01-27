package algo.stack;

import algo.stack.problems.Browser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BrowserTest {

  @Test
  public void testBrowser() {
    Browser browser = new Browser();

    assertEquals("a", browser.open("a"));
    assertEquals("b", browser.open("b"));
    assertEquals("c", browser.open("c"));

    assertEquals("c", browser.back());
    assertEquals("b", browser.back());

    assertEquals("b", browser.forward());

    assertEquals("d",browser.open("d") );

    assertEquals("d", browser.back());
    assertEquals("b", browser.back());
    assertEquals("a", browser.back());
  }
}
