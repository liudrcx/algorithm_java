package algo.heap;

public abstract class BaseHeap<E extends Comparable<E>> implements Heap<E>{

  private int size = 0;

  private int capacity = 0;

  private E[] data;

  protected boolean isMinHeap = false;

  public BaseHeap(int capacity, boolean isMinHeap) {
    this.capacity = capacity;
    this.isMinHeap = isMinHeap;

    this.data = (E[]) new Comparable[capacity];
    this.isMinHeap = isMinHeap;
  }

  public BaseHeap(E[] data, boolean isMinHeap) {
    this.capacity = data.length;
    this.size = data.length;
    this.data = data;
    this.isMinHeap = isMinHeap;
    heapify();
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean isFull() {
    return size == capacity;
  }

  @Override
  public E peek() {
    if (isEmpty()) {
      throw new IllegalStateException("heap is empty");
    }
    return data[0];
  }

  @Override
  public E poll() {
    if (isEmpty()) {
      throw new IllegalStateException("heap is empty");
    }

    E top = data[0];
    swap(0, size - 1);
    data[size - 1] = null; //for GC, avoid to memory leak
    size--;
    down(0);
    return top;
  }

  @Override
  public void replace(E e) {
    data[0] = e;
    down(0);
  }

  @Override
  public void offer(E e) {
    if (isFull()) {
      throw new IllegalStateException("heap is full");
    }

    up(e);
    size++;
  }

  private void heapify() {
    // iterating down from none-leaf node
    for (int i = size / 2 - 1; i >= 0; i--) {
      down(i);
    }
  }

  private void down(int parentIndex) {
    int leftIndex = parentIndex * 2 + 1;
    int rightIndex = leftIndex + 1;

    int swapIndex = parentIndex;
    if (leftIndex < size && shouldDownSwap(leftIndex, swapIndex))  {
      swapIndex = leftIndex;
    }

    if (rightIndex < size && shouldDownSwap(rightIndex, swapIndex)) {
      swapIndex = rightIndex;
    }

    if (swapIndex != parentIndex) {
      swap(parentIndex, swapIndex);
      down(swapIndex);
    }
  }

  private boolean shouldDownSwap(int childIndex, int swapIndex) {
    return (!isMinHeap && data[childIndex].compareTo(data[swapIndex]) > 0)
      || (isMinHeap && data[childIndex].compareTo(data[swapIndex]) < 0);
  }

  private void up(E e) {
    int childIndex = size;
    while(childIndex > 0) {
      int parentIndex = (childIndex - 1) / 2;
      if (shouldUp(parentIndex, e)) {
        data[childIndex] = data[parentIndex];
        childIndex = parentIndex;
      } else {
        break;
      }
    }

    data[childIndex] = e;
  }

  private boolean shouldUp(int parentIndex, E e) {
    return (!isMinHeap && data[parentIndex].compareTo(e) < 0)
      || (isMinHeap && data[parentIndex].compareTo(e) > 0);
  }

  private void swap(int leftIndex, int rightIndex) {
    E tmp = data[leftIndex];
    data[leftIndex] = data[rightIndex];
    data[rightIndex] = tmp;
  }


}
