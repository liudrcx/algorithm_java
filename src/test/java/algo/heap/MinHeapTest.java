package algo.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {

  @Test
  public void testOfferAndPoll() {
    MinHeap<Integer> heap = new MinHeap<>();
    heap.offer(7);
    heap.offer(2);
    heap.offer(3);
    heap.offer(4);
    heap.offer(6);

    assertEquals(2, heap.poll());
    assertEquals(3, heap.poll());
    assertEquals(4, heap.poll());
    assertEquals(6, heap.poll());
    assertEquals(7, heap.poll());
  }

  @Test
  public void testHeapify() {
    MinHeap<Integer> heap = new MinHeap<>(new Integer[] {2, 3, 4, 6, 7});

    assertEquals(2, heap.poll());
    assertEquals(3, heap.poll());
    assertEquals(4, heap.poll());
    assertEquals(6, heap.poll());
    assertEquals(7, heap.poll());
  }
}
