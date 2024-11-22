package algo.sorting;

import java.util.Comparator;

public class HeapSorting {

  public static <T extends Comparable<T>> void sort(T[] data) {
    if (data == null || data.length == 1) {
      return;
    }

    Heap<T> heap = new Heap<>(data);

    while(heap.size > 0) {
      heap.swap(0, heap.size - 1);
      heap.size--;
      heap.down(0);
    }
  }

  static class Heap<T extends Comparable<T>> {

    T[] data;

    int size;

    Heap(T[] data) {
      this.data = data;
      this.size = data.length;
      heapify();
    }

    void heapify() {
      for (int i = size / 2 - 1; i >= 0; i--) {
        down(i);
      }
    }

    void down(int parent) {
      while (true) {
        int left = parent * 2 + 1;
        int right = left + 1;

        int max = parent;
        if (left < size && data[left].compareTo(data[max]) > 0) {
          max = left;
        }

        if (right < size && data[right].compareTo(data[max]) > 0) {
          max = right;
        }

        if (max == parent) {
          break;
        }

        swap(parent, max);
        parent = max;
      }
    }

    void swap(int left, int right) {
      T t = data[left];
      data[left] = data[right];
      data[right] = t;
    }
  }
}
