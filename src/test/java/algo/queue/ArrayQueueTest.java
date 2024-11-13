package algo.queue;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayQueueTest {

  @Test
  public void testIsEmpty() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();
    assertTrue(queue.isEmpty());

    queue = new ArrayQueue<>(new Integer[]{1, 2});
    assertFalse(queue.isEmpty());
  }

  @Test
  public void testIsFull() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();
    assertFalse(queue.isFull());

    queue = new ArrayQueue<>(new Integer[]{1, 2});
    assertTrue(queue.isFull());
  }

  @Test
  public void testGetSize() {
    ArrayQueue<Integer> queue = new ArrayQueue<>();
    assertEquals(0, queue.size());

    queue = new ArrayQueue<>(new Integer[]{1, 2});
    assertEquals(2, queue.size());
  }

  @Test
  public void testOffer() {
    ArrayQueue<Integer> queue = new ArrayQueue<>(4);
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);

    assertThrowsExactly(IllegalArgumentException.class, () -> queue.offer(5));

    assertFalse(queue.isEmpty());
    assertTrue(queue.isFull());
    assertEquals(4, queue.size());
    assertIterableEquals(List.of(1, 2, 3, 4), queue);
  }

  @Test
  public void testPoll() {
    ArrayQueue<Integer> queue = new ArrayQueue<>(new Integer[] {1, 2});

    assertEquals(1, queue.poll());
    assertEquals(2, queue.poll());
    assertThrowsExactly(IllegalArgumentException.class, () -> queue.poll());
  }

  @Test
  public void testPeek() {
    ArrayQueue<Integer> queue = new ArrayQueue<>(new Integer[] {1, 2});
    assertEquals(1, queue.peek());

    ArrayQueue<Integer> emptyQueue = new ArrayQueue<>();
    assertThrowsExactly(IllegalArgumentException.class, () -> emptyQueue.peek());
  }
}
