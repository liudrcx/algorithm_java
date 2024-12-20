package algo.tree.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static algo.tree.problems.Construct_PostExpression_To_ExpressionTree.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class Construct_PostExpression_To_ExpressionTree_Test {

  @Test
  public void testConstruct() {
    TreeNode tree = construct(List.of("2", "1", "-", "3", "*").toArray(new String[0]));

    List<String> list = postIteration(tree);
    assertIterableEquals(List.of("2", "1", "-", "3", "*"), list);
  }
}
