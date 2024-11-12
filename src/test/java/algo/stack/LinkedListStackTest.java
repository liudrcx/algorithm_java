package algo.stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class LinkedListStackTest {

  @Test
  public void testPush() {
    LinkedListStack<Integer> stack = new LinkedListStack<>(5);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    assertThrowsExactly(
      IllegalStateException.class,
      () -> stack.push(6)
    );

    assertIterableEquals(List.of(5, 4, 3, 2, 1), stack);
  }

  @Test
  public void testPoll() {
    LinkedListStack<Integer> stack = new LinkedListStack<>(new Integer[] {1, 2});

    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
    assertThrowsExactly(IllegalStateException.class, () -> stack.pop());
  }

  @Test
  public void testPeek() {
    LinkedListStack<Integer> stack1 = new LinkedListStack<>();
    assertThrowsExactly(IllegalStateException.class, () -> stack1.peek());

    LinkedListStack<Integer> stack2 = new LinkedListStack<>(new Integer[] {1, 2});
    assertEquals(2, stack2.peek());
  }
}
