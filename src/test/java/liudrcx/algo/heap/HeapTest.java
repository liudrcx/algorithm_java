package liudrcx.algo.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HeapTest {

  @Test
  public void testMaxHeap() {
    MaxHeap<Integer> heap = new MaxHeap<>(10);
    heap.offer(7);
    heap.offer(2);
    heap.offer(3);
    heap.offer(4);
    heap.offer(6);

    assertThat(heap.poll()).isEqualTo(7);
    assertThat(heap.poll()).isEqualTo(6);
    assertThat(heap.poll()).isEqualTo(4);
    assertThat(heap.poll()).isEqualTo(3);
    assertThat(heap.poll()).isEqualTo(2);
  }

  @Test
  public void testMinHeap() {
    MinHeap<Integer> heap = new MinHeap<>(5);
    heap.offer(7);
    heap.offer(2);
    heap.offer(3);
    heap.offer(4);
    heap.offer(6);

    assertThat(heap.offer(8)).isFalse();
    assertThat(heap.poll()).isEqualTo(2);
    assertThat(heap.poll()).isEqualTo(3);
    assertThat(heap.poll()).isEqualTo(4);
    assertThat(heap.poll()).isEqualTo(6);
    assertThat(heap.poll()).isEqualTo(7);
    assertThat(heap.poll()).isNull();
  }
}
