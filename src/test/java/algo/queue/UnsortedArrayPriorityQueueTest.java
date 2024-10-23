package algo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class UnsortedArrayPriorityQueueTest {

  @Test
  public void testOfferAndPoll() {
    UnsortedArrayPriorityQueue<PriorityEntry> queue = new UnsortedArrayPriorityQueue<>(5);
    queue.offer(new PriorityEntry("task1", 4));
    queue.offer(new PriorityEntry("task2", 3));
    queue.offer(new PriorityEntry("task3", 2));
    queue.offer(new PriorityEntry("task4", 5));
    queue.offer(new PriorityEntry("task5", 1));
    assertThrowsExactly(
      IllegalStateException.class,
      () -> queue.offer(new PriorityEntry("task6", 7))
    );

    assertEquals(5, queue.poll().priority());
    assertEquals(4, queue.poll().priority());
    assertEquals(3, queue.poll().priority());
    assertEquals(2, queue.poll().priority());
    assertEquals(1, queue.poll().priority());
  }
}
