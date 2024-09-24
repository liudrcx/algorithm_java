package algoritm.queue;

import algorithm.queue.DynamicArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DynamicArrayQueueTest {

  @Test
  public void testOfferAndPoll() {
    DynamicArrayQueue<Integer> queue = new DynamicArrayQueue<>();
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);

    assertEquals(3, queue.size() );
    assertEquals(1, queue.poll());
    assertEquals(2, queue.poll());
    assertEquals(3, queue.poll());
    assertThrows(RuntimeException.class, () -> queue.poll());
  }

  @Test
  public void testPeek() {
    DynamicArrayQueue<Integer> queue = new DynamicArrayQueue<>();
    queue.offer(1);
    queue.offer(2);

    assertEquals(1, queue.peek());
    assertEquals(1, queue.poll());

    assertEquals(2, queue.peek());
    assertEquals(2, queue.poll());

    assertThrows(RuntimeException.class, () -> queue.peek());
  }
}
