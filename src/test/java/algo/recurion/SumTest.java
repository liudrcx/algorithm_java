package algo.recurion;

import algo.recursion.Sum;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SumTest {

  @Test
  public void testSum() {
    int result = Sum.exec(100);
    assertThat(result).isEqualTo(5050);
  }
}
