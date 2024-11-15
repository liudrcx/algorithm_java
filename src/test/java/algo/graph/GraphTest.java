package algo.graph;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GraphTest {

  @Test
  public void testDFS() {
    Graph graph = new Graph(new String[][] {
      {"Beijing", "Guangzhou"},
      {"Beijing", "Wuhan"},
      {"Wuhan", "Guangzhou"},
      {"Beijing", "Shanghai"},
      {"Wuhan", "Shanghai"}
    });

    List<String> path = graph.dfsPath("Beijing");
    assertIterableEquals(List.of("Beijing", "Guangzhou", "Wuhan", "Shanghai"), path);
  }

  @Test
  public void testDfsPathByIteration() {
    Graph graph = new Graph(new String[][] {
      {"Beijing", "Guangzhou"},
      {"Beijing", "Wuhan"},
      {"Wuhan", "Guangzhou"},
      {"Beijing", "Shanghai"},
      {"Wuhan", "Shanghai"}
    });

    List<String> path = graph.dfsPathByIteration("Beijing");
    assertIterableEquals(List.of("Beijing", "Shanghai", "Wuhan", "Guangzhou"), path);
  }

  @Test
  public void testBFS() {
    Graph graph = new Graph(new String[][] {
      {"Beijing", "Guangzhou"},
      {"Beijing", "Wuhan"},
      {"Wuhan", "Guangzhou"},
      {"Beijing", "Shanghai"},
      {"Wuhan", "Shanghai"}
    });

    List<String> path = graph.bfs("Beijing");
    assertIterableEquals(List.of("Beijing", "Guangzhou", "Wuhan", "Shanghai"), path);
  }

  @Test
  public void testTopologicalSortByKahn() {
    Graph graph = new Graph(new String[][] {
      {"Beijing", "Guangzhou"},
      {"Beijing", "Wuhan"},
      {"Wuhan", "Guangzhou"},
      {"Beijing", "Shanghai"},
      {"Wuhan", "Shanghai"}
    });

    List<String> result = graph.topologicalSortByKahn();
    assertIterableEquals(List.of("Beijing", "Wuhan", "Guangzhou", "Shanghai"), result);

    Graph graph2 = new Graph(new String[][] {
      {"Beijing", "Guangzhou"},
      {"Beijing", "Wuhan"},
      {"Wuhan", "Guangzhou"},
      {"Beijing", "Shanghai"},
      {"Wuhan", "Shanghai"},
      {"Shanghai", "Wuhan"}
    });
    assertThrows(IllegalStateException.class, () -> graph2.topologicalSortByKahn());
  }

  @Test
  public void topologicalSortByDfs() {
    Graph graph = new Graph(new String[][] {
      {"Beijing", "Guangzhou"},
      {"Beijing", "Wuhan"},
      {"Wuhan", "Guangzhou"},
      {"Beijing", "Shanghai"},
      {"Wuhan", "Shanghai"}
    });

    List<String> result = graph.topologicalSortByDfs();
    assertIterableEquals(List.of("Beijing", "Wuhan", "Shanghai", "Guangzhou"), result);

    Graph graph2 = new Graph(new String[][] {
      {"Beijing", "Guangzhou"},
      {"Beijing", "Wuhan"},
      {"Wuhan", "Guangzhou"},
      {"Beijing", "Shanghai"},
      {"Wuhan", "Shanghai"},
      {"Shanghai", "Wuhan"}
    });
    assertThrows(IllegalStateException.class, () -> graph2.topologicalSortByDfs());
  }


}
