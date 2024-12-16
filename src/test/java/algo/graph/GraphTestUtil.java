package algo.graph;


import org.junit.jupiter.api.Assertions;
import org.opentest4j.AssertionFailedError;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class GraphTestUtil {

  public static <T> void assertContainsPath(List<List<T>> expectedPaths, List<T> actualPath) {
    for (List<T> expectedPath : expectedPaths) {
      if (isSamePath(expectedPath, actualPath)) {
        return;
      }
    }
    fail();
  }

  private static <T> boolean isSamePath(List<T> expectedPath, List<T> actualPath) {
    try {
      assertIterableEquals(expectedPath, actualPath);
      return true;
    } catch (AssertionFailedError e) {
      return false;
    }
  }

}
