package algo.stack.problems;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InfixToSuffixTest {

   @Test
  public void testInfixToSuffix() {
    InfixToSuffix parser = new InfixToSuffix();

    assertThat(parser.eval("a+b")).isEqualTo("ab+");
    assertThat(parser.eval("a+b-c")).isEqualTo("ab+c-");
    assertThat(parser.eval("a+b*c")).isEqualTo("abc*+");
    assertThat(parser.eval("a*b-c")).isEqualTo("ab*c-");
    assertThat(parser.eval("(a+b)*c")).isEqualTo("ab+c*");
    assertThat(parser.eval("a+b*c+(d*e+f)*g")).isEqualTo("abc*+de*f+g*+");
  }
}
