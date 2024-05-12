package liudrcx.ds.stack;


import liudrcx.problems.stack.InfixToSuffix;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InfixToSuffixTest {

  @Test
  public void testInfixToSuffix() {
    InfixToSuffix parser = new InfixToSuffix();

    assertThat(parser.parse("a+b")).isEqualTo("ab+");
    assertThat(parser.parse("a+b-c")).isEqualTo("ab+c-");
    assertThat(parser.parse("a+b*c")).isEqualTo("abc*+");
    assertThat(parser.parse("a*b-c")).isEqualTo("ab*c-");
    assertThat(parser.parse("(a+b)*c")).isEqualTo("ab+c*");
    assertThat(parser.parse("a+b*c+(d*e+f)*g")).isEqualTo("abc*+de*f+g*+");
  }
}
