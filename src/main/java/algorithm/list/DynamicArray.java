package algorithm.list;

import java.util.Iterator;

public class DynamicArray<E> implements ListDs<E>{

  private int capacity = 0;

  private int size = 0;

  private E[] data;

  public DynamicArray(int capacity) {
    this.capacity = capacity;
    data = (E[]) new Object[capacity];
  }

  public DynamicArray() {
    this(15);
  }

  @Override
  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    if (isFull()) {
      growCapacity();
    }

    System.arraycopy(data, index, data, index + 1, size - index);

    data[index] = e;
    size++;
  }

  private void growCapacity() {
    capacity += capacity >>> 1;
    E[] newData = (E[]) new Object[capacity];
    System.arraycopy(data, 0, newData, 0, size);
    data = newData;
  }

  @Override
  public void addFirst(E e) {
    add(0, e);
  }

  @Override
  public void addLast(E e) {
    add(size, e);
  }

  @Override
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    E e = data[index];

    if (index < size - 1) {
      System.arraycopy(data, index + 1, data, index , size - index - 1);
    }

    size--;
    return e;
  }

  @Override
  public E removeFirst() {
    return remove(0);
  }

  @Override
  public E removeLast() {
    return remove(size - 1);
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
  public Iterator<E> iterator() {
    return new Iterator<E>() {

      int currentIndex = 0;

      @Override
      public boolean hasNext() {
        return currentIndex != size;
      }

      @Override
      public E next() {
        E e = data[currentIndex];
        currentIndex++;
        return e;
      }
    };
  }
}
