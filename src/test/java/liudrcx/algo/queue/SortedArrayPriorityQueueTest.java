package liudrcx.algo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SortedArrayPriorityQueueTest {

  @Test
  public void poll() {
    SortedArrayPriorityQueue<Entry> queue = new SortedArrayPriorityQueue<>(5);
    queue.offer(new Entry("task1", 4));
    queue.offer(new Entry("task2", 3));
    queue.offer(new Entry("task3", 2));
    queue.offer(new Entry("task4", 5));
    queue.offer(new Entry("task5", 1));
    assertFalse(queue.offer(new Entry("task6", 7)));

    assertEquals(5, queue.poll().priority());
    assertEquals(4, queue.poll().priority());
    assertEquals(3, queue.poll().priority());
    assertEquals(2, queue.poll().priority());
    assertEquals(1, queue.poll().priority());
  }

  static class Entry implements Priority {

    private String name;
    private int priority;

    public Entry(String name, int priority) {
      this.name = name;
      this.priority = priority;
    }

    @Override
    public int priority() {
      return priority;
    }
  }
}
