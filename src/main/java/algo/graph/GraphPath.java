package algo.graph;

import java.util.List;

public interface GraphPath<T> {
  List<T> findPath(T start, T end);
}
