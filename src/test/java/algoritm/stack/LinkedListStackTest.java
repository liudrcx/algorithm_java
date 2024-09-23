package algoritm.stack;

import algorithm.stack.LinkedListStack;
import algorithm.stack.StackDs;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListStackTest {

  @Test
  public void testPushAndPop() {
    StackDs<Integer> stack = new LinkedListStack<>();
    stack.push(1);
    stack.push(2);
    stack.push(3);

    assertEquals(3, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
    assertThrows(RuntimeException.class, () -> stack.pop());
  }
}
