package algo.greedy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static algo.greedy.N518_Coin_Change_II.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class N518_Coin_Change_II_Test {

  @Test
  public void testSolution1() {
    Solution1 solution1 = new Solution1();
    int count = solution1.change(5, new int[]{1, 2, 5});
    assertEquals(4, count);
  }
}
