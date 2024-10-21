package algo.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxHeapTest {

  @Test
  public void testOfferAndPoll() {
    MaxHeap<Integer> heap = new MaxHeap<>();
    heap.offer(7);
    heap.offer(2);
    heap.offer(3);
    heap.offer(4);
    heap.offer(6);

    assertEquals(7, heap.poll());
    assertEquals(6, heap.poll());
    assertEquals(4, heap.poll());
    assertEquals(3, heap.poll());
    assertEquals(2, heap.poll());
  }

  @Test
  public void testHeapify() {
    MaxHeap<Integer> heap = new MaxHeap<>(new Integer[] {2, 3, 4, 6, 7});

    assertEquals(7, heap.poll());
    assertEquals(6, heap.poll());
    assertEquals(4, heap.poll());
    assertEquals(3, heap.poll());
    assertEquals(2, heap.poll());
  }
}
