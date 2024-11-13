package algo.queue;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ArrayCycleQueueTest {

  @Test
  public void testIsEmpty() {
    ArrayCycleQueue<Integer> queue = new ArrayCycleQueue<>();
    assertTrue(queue.isEmpty());

    queue = new ArrayCycleQueue<>(new Integer[]{1, 2});
    assertFalse(queue.isEmpty());
  }

  @Test
  public void testIsFull() {
    ArrayCycleQueue<Integer> queue = new ArrayCycleQueue<>();
    assertFalse(queue.isFull());

    queue = new ArrayCycleQueue<>(new Integer[]{1, 2});
    assertTrue(queue.isFull());
  }

  @Test
  public void testGetSize() {
    ArrayCycleQueue<Integer> queue = new ArrayCycleQueue<>();
    assertEquals(0, queue.size());

    queue = new ArrayCycleQueue<>(new Integer[]{1, 2});
    assertEquals(2, queue.size());
  }

  @Test
  public void testOffer() {
    ArrayCycleQueue<Integer> queue = new ArrayCycleQueue<>(4);
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
    ArrayCycleQueue<Integer> queue = new ArrayCycleQueue<>(new Integer[] {1, 2});

    assertEquals(1, queue.poll());
    assertEquals(2, queue.poll());
    assertThrowsExactly(IllegalArgumentException.class, () -> queue.poll());
  }

  @Test
  public void testPeek() {
    ArrayCycleQueue<Integer> queue = new ArrayCycleQueue<>(new Integer[] {1, 2});
    assertEquals(1, queue.peek());

    ArrayCycleQueue<Integer> emptyQueue = new ArrayCycleQueue<>();
    assertThrowsExactly(IllegalArgumentException.class, () -> emptyQueue.peek());
  }
}
