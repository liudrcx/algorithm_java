package aliu.ds.stack;

import aliu.problems.ds.stack.ArrayStack;
import aliu.problems.ds.stack.Stack;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ArrayStackTest {

  @Test
  public void push() {
    Stack<Integer> stack = new ArrayStack<>(3);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    assertFalse(stack.push(4));

    assertIterableEquals(List.of(3, 2, 1), stack);
  }

  @Test
  public void pop() {
    Stack<Integer> stack = new ArrayStack<>(3);
    stack.push(1);
    stack.push(2);
    stack.push(3);
    // 3, 2, 1
    assertEquals(3, stack.pop());
    assertEquals(2, stack.pop());
    assertEquals(1, stack.pop());
    assertNull(stack.pop());
  }
}
