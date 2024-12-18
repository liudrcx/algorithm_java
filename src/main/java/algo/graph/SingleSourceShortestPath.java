package algo.graph;

import java.util.List;

public interface SingleSourceShortestPath<T> {

  List<List<T>> findPaths(T source);
}
