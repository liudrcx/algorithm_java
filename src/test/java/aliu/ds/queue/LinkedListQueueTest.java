package aliu.ds.queue;

import aliu.ds.queue.LinkedListQueue;
import aliu.ds.queue.Queue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListQueueTest {

  @Test
  public void generic() {
    LinkedListQueue<String> queue =
        new LinkedListQueue<>(3);
    queue.offer("a");
    queue.offer("b");
    queue.offer("c");
    assertFalse(queue.offer("d"));
    assertFalse(queue.offer("e"));

    assertIterableEquals(List.of("a", "b", "c"), queue);
  }

  @Test
  public void offerLimit() {
    LinkedListQueue<Integer> queue =
        new LinkedListQueue<>(3);
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    assertFalse(queue.offer(4));
    assertFalse(queue.offer(5));

    assertIterableEquals(List.of(1, 2, 3), queue);
  }

  @Test
  public void poll1() {
    Queue<Integer> queue = new LinkedListQueue<>(5);
    queue.offer(1);
    assertEquals(1, queue.poll());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void offer() {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>(5);
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);
    queue.offer(4);
    queue.offer(5);

    assertIterableEquals(List.of(1, 2, 3, 4, 5), queue);
  }

  @Test
  public void peek() {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>(5);
    assertNull(queue.peek());
    queue.offer(1);
    assertEquals(1, queue.peek());
    queue.offer(2);
    assertEquals(1, queue.peek());
  }

  @Test
  public void poll() {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>(5);
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);

    assertEquals(1, queue.poll());
    assertEquals(2, queue.poll());
    assertEquals(3, queue.poll());
    assertNull(queue.poll());

    queue.offer(4);
    queue.offer(5);
    queue.offer(6);
    assertIterableEquals(List.of(4, 5, 6), queue);
  }
}
