package algo.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cut_Rot_Problem_Test {

  @Test
  public void testCut1() {
    int result = Cut_Rot_Problem.cut1(new int[]{0, 1, 5, 8, 9}, 4);
    assertEquals(10, result);
  }

  @Test
  public void testCut2() {
    int result = Cut_Rot_Problem.cut2(new int[]{0, 1, 5, 8, 9}, 4);
    assertEquals(10, result);
  }
}
