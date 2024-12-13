package algo.greedy;

import org.junit.jupiter.api.Test;

import static algo.greedy.N322_Coin_Change.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class N322_Coin_ChangeTest {

  @Test
  public void testSolution1() {
    Solution1 solution1 = new Solution1();
    int count = solution1.coinChange(new int[]{1, 2, 5}, 5);
    assertEquals(1, count);

    solution1 = new Solution1();
    count = solution1.coinChange(new int[]{1, 2, 5}, 11);
    assertEquals(3, count);
  }
}
