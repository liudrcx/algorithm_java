package aliu.algo.recursion;

import aliu.algo.recursion.Factorial;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FactorialTest {

  @Test
  public void testFactorial() {
    int result = Factorial.factorial(5);
    assertThat(result).isEqualTo(120);
  }
}
