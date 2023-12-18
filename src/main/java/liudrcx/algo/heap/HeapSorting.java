package liudrcx.algo.heap;

public class HeapSorting {

  public void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    MaxHeap maxHeap = new MaxHeap(arr);
    while(maxHeap.size > 1) {
      maxHeap.swap(0, maxHeap.size - 1);
      maxHeap.size--;
      maxHeap.down(0);
    }
  }

  public static class MaxHeap {

    private int[] array;
    private int size = 0;

    public MaxHeap(int[] array) {
      this.array = array;
      this.size = array.length;
      heapify();
    }

    public int peek() {
      return array[0];
    }

    public int poll() {
      int deleted = array[0];
      swap(0, size - 1);
      size--;
      down(0);
      return deleted;
    }

    public int poll(int index) {
      int deleted = array[index];
      swap(index, size - 1);
      size--;
      down(index);
      return deleted;
    }

    public boolean offer(int value) {
      if (size == array.length) {
        return false;
      }
      up(value);
      size++;
      return true;
    }

    public void up(int value) {
      int child = size;
      while(child > 0) {
        int parent = (child - 1) / 2;
        if (value > array[parent]) {
          array[child] = array[parent];
        } else {
          break;
        }
        child = parent;
      }
      array[child] = value;
    }

    private void heapify() {
      for(int i = size / 2 - 1; i >= 0; i--) {
        down(i);
      }
    }

    private void down(int parent) {
      while(true) {
        int max = parent;

        int left = parent * 2 + 1;
        int right = left + 1;

        if (left < size && array[max] < array[left]) {
          max = left;
        }
        if (right < size && array[max] < array[right]) {
          max = right;
        }
        if (max == parent) {
          break;
        }
        swap(max, parent);
        parent = max;
      }
    }

    private void swap(int i, int j) {
      int t = array[i];
      array[i] = array[j];
      array[j] = t;
    }
  }
}
