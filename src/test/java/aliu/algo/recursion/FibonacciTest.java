package aliu.algo.recursion;

import aliu.algo.recursion.Fibonacci;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class FibonacciTest {

  @Test
  public void testExec() {
    int result = Fibonacci.exec(5);
    Assertions.assertThat(result).isEqualTo(5);
  }
}
