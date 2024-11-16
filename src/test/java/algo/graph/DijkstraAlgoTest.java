package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class DijkstraAlgoTest {

  @Test
  public void testMinPathDistanceOf() {
    DijkstraAlgo algo = new DijkstraAlgo(
      new String[][] {
        {"1", "6", "14"},
        {"1", "2", "7"},
        {"1", "3", "9"},
        {"6", "5", "9"},
        {"2", "4", "15"},
        {"3", "6", "2"},
        {"3", "4", "11"},
        {"4", "5", "6"}
      }
    );

    assertEquals(0, algo.minPathDistanceOf("1", "1"));
    assertEquals(7, algo.minPathDistanceOf("1", "2"));
    assertEquals(9, algo.minPathDistanceOf("1", "3"));
    assertEquals(20, algo.minPathDistanceOf("1", "4"));
    assertEquals(20, algo.minPathDistanceOf("1", "5"));
    assertEquals(11, algo.minPathDistanceOf("1", "6"));
  }

  @Test
  public void testMinPath() {
    DijkstraAlgo algo = new DijkstraAlgo(
      new String[][] {
        {"1", "6", "14"},
        {"1", "2", "7"},
        {"1", "3", "9"},
        {"6", "5", "9"},
        {"2", "4", "15"},
        {"3", "6", "2"},
        {"3", "4", "11"},
        {"4", "5", "6"}
      }
    );

    assertIterableEquals(List.of("1"), algo.minPathOf("1", "1"));
    assertIterableEquals(List.of("1", "2"), algo.minPathOf("1", "2"));
    assertIterableEquals(List.of("1", "3"), algo.minPathOf("1", "3"));
    assertIterableEquals(List.of("1", "3", "4"), algo.minPathOf("1", "4"));
    assertIterableEquals(List.of("1", "3", "6", "5"), algo.minPathOf("1", "5"));
    assertIterableEquals(List.of("1", "3", "6"), algo.minPathOf("1", "6"));
  }
}
