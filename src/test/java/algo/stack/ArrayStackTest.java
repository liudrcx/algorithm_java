package algo.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class ArrayStackTest {

  @Test
  public void testPush() {
    ArrayStack<Integer> stack = new ArrayStack<>(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertThrowsExactly(
      IllegalStateException.class,
      () -> stack.push(6)
    );

    assertIterableEquals(List.of(1, 2, 3, 4, 5), stack);
  }

  @Test
  public void testPoll() {
    ArrayStack<Integer> stack = new ArrayStack<>(new Integer[] {1, 2});

    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
    assertThrowsExactly(IllegalStateException.class, () -> stack.pop());
  }

  @Test
  public void testPeek() {
    ArrayStack<Integer> stack1 = new ArrayStack<>(new Integer[] {});
    assertThrowsExactly(IllegalStateException.class, () -> stack1.peek());

    ArrayStack<Integer> stack2 = new ArrayStack<>(new Integer[] {1, 2});
    assertEquals(2, stack2.peek());
  }
}
