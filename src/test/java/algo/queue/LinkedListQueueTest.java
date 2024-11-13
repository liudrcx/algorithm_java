package algo.queue;

import algo.list.linkedlist.SinglyLinkedList;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListQueueTest {

  @Test
  public void testIsEmpty() {
    LinkedListQueue<Integer> list = new LinkedListQueue<>();
    assertTrue(list.isEmpty());

    list = new LinkedListQueue<>(new Integer[]{1, 2});
    assertFalse(list.isEmpty());
  }

  @Test
  public void testIsFull() {
    LinkedListQueue<Integer> list = new LinkedListQueue<>();
    assertFalse(list.isFull());

    list = new LinkedListQueue<>(new Integer[]{1, 2});
    assertTrue(list.isFull());
  }

  @Test
  public void testGetSize() {
    LinkedListQueue<Integer> list = new LinkedListQueue<>();
    assertEquals(0, list.size());

    list = new LinkedListQueue<>(new Integer[]{1, 2});
    assertEquals(2, list.size());
  }

  @Test
  public void testOffer() {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>(4);
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
    LinkedListQueue<Integer> queue = new LinkedListQueue<>(new Integer[] {1, 2});

    assertEquals(1, queue.poll());
    assertEquals(2, queue.poll());
    assertThrowsExactly(IllegalArgumentException.class, () -> queue.poll());
  }

  @Test
  public void testPeek() {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>(new Integer[] {1, 2});
    assertEquals(1, queue.peek());

    LinkedListQueue<Integer> emptyQueue = new LinkedListQueue<>();
    assertThrowsExactly(IllegalArgumentException.class, () -> emptyQueue.peek());
  }
}
