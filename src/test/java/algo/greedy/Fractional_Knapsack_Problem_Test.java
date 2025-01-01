package algo.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static algo.greedy.Fractional_Knapsack_Problem.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Fractional_Knapsack_Problem_Test {

  @Test
  public void testSelect() {
    Item[] items = new Item[]{
      new Item(0, 4, 24),
      new Item(1, 8, 160),
      new Item(2, 2, 4000),
      new Item(3, 6, 108),
      new Item(4, 1, 4000),
    };

    int result = Fractional_Knapsack_Problem.select(new ArrayList<>(List.of(items)), 10);
    assertEquals(8140, result);
  }
}
