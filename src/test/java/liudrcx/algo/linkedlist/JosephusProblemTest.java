package liudrcx.algo.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class JosephusProblemTest {

  @Test
  public void testExecute() {
    JosephusProblem problem = new JosephusProblem();
    List<Integer> result = problem.execute(3, 2);
    assertIterableEquals(List.of(3, 1, 2), result);
  }
}
