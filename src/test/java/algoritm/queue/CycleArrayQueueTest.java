package algoritm.queue;

import algorithm.queue.CycleArrayQueue;
import algorithm.queue.DynamicArrayQueue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CycleArrayQueueTest {

  @Test
  public void testOfferAndPoll() {
    CycleArrayQueue<Integer> queue = new CycleArrayQueue<>(3);
    queue.offer(1);
    queue.offer(2);
    queue.offer(3);

    assertFalse(queue.offer(4));
    assertEquals(3, queue.size() );
    assertEquals(1, queue.poll());

    queue.offer(4);
    assertEquals(3, queue.size());
    assertEquals(2, queue.poll());
    assertEquals(3, queue.poll());
    assertEquals(4, queue.poll());

    assertThrows(RuntimeException.class, () -> queue.poll());
  }

  @Test
  public void testPeek() {
    CycleArrayQueue<Integer> queue = new CycleArrayQueue<>();
    queue.offer(1);
    queue.offer(2);

    assertEquals(1, queue.peek());
    assertEquals(1, queue.poll());

    assertEquals(2, queue.peek());
    assertEquals(2, queue.poll());

    assertThrows(RuntimeException.class, () -> queue.peek());
  }
}
