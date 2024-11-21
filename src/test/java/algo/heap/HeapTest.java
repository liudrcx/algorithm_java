package algo.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HeapTest {

  @Test
  public void testHeapify() {
    Heap<Integer> heap = new Heap<>(new Integer[] {1, 2, 3, 4, 5, 6, 7}, (a, b) -> b - a);
    assertArrayEquals(new Integer[] {7, 5, 6, 4, 2, 1, 3}, heap.data);

    heap = new Heap<>(new Integer[] {7, 6, 5, 4, 3, 2, 1}, (a, b) -> a - b);
    assertArrayEquals(new Integer[] {1, 3, 2, 4, 6, 7, 5},heap.data);
  }

  @Test
  public void testPeek() {
    Heap<Integer> heap = new Heap<>(new Integer[] {1, 2, 3, 4, 5, 6, 7}, (a, b) -> b - a);
    assertEquals(7, heap.peek());

    Heap<Integer> emptyHeap = new Heap<>((a, b) -> b - a);
    assertThrows(IllegalStateException.class, () -> emptyHeap.peek());
  }

  @Test
  public void testPoll() {
    Heap<Integer> heap = new Heap<>(new Integer[] {1, 2, 3, 4, 5, 6, 7}, (a, b) -> b - a);

    assertEquals(7, heap.poll());
    assertEquals(6, heap.poll());
    assertEquals(5, heap.poll());
    assertEquals(4, heap.poll());
    assertEquals(3, heap.poll());
    assertEquals(2, heap.poll());
    assertEquals(1, heap.poll());
    assertThrows(IllegalStateException.class, () -> heap.poll());
  }

  @Test
  public void testOffer() {
    Heap<Integer> heap = new Heap<>((a, b) -> b - a);
    heap.offer(1);
    heap.offer(2);
    heap.offer(3);

    assertEquals(3, heap.poll());
    assertEquals(2, heap.poll());
    assertEquals(1, heap.poll());
    assertThrows(IllegalStateException.class, () -> heap.poll());
  }

  @Test
  public void testReplace() {
    Heap<Integer> heap = new Heap<>((a, b) -> b - a);
    heap.offer(5);
    heap.offer(2);
    heap.offer(3);

    heap.replace(1);

    assertEquals(3, heap.poll());
    assertEquals(2, heap.poll());
    assertEquals(1, heap.poll());
    assertThrows(IllegalStateException.class, () -> heap.poll());
  }
}
