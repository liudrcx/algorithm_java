package liudrcx.algo.heap;

import java.util.Arrays;

public class MaxHeap {

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

  public void replace(int replaced) {
    array[0] = replaced;
    down(0);
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

  public int size() {
    return size;
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7};
    MaxHeap maxHeap = new MaxHeap(array);
    System.out.println(Arrays.toString(maxHeap.array)); //[7, 5, 6, 4, 2, 1, 3]
  }
}
