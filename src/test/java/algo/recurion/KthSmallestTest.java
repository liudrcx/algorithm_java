package algo.recurion;

import algo.recursion.KthSmallest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KthSmallestTest {

  @Test
  public void testKthSmallest() {
    int[] arr = {3, 1, 4, 2, 5};
    int result = KthSmallest.kthSmallest(arr, 3);
    assertThat(result).isEqualTo(3);
  }
}
