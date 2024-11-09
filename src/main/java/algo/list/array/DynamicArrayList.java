package algo.list.array;

import algo.list.List;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArrayList<E> implements List<E>, Iterable<E> {

  private E[] data;

  private int size;

  private int initSize;

  public DynamicArrayList(int initSize) {
    this.initSize = initSize;
    this.size = 0;
    this.data = (E[]) new Object[initSize];
  }

  public DynamicArrayList() {
    this(16);
  }

  /**
   * for testing
   */
  protected DynamicArrayList(E[] data) {
    this.data = data;
    this.size = data.length;
    this.initSize = data.length;
  }

  @Override
  public void add(int index, E e) {
    checkIncrIndex(index);
    checkAndGrow();

    if (index < size) {
      System.arraycopy(data, index, data, index + 1, size - index);
    }

    data[index] = e;
    size++;
  }

  private void checkIncrIndex(int index) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("invalid index: " + index);
    }
  }

  private void checkAndGrow() {
    if (size == initSize) {
      initSize = initSize * 2;
      E[] newData = (E[]) new Object[initSize];
      System.arraycopy(data,0, newData, 0, size);
      data = newData;
    }
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
    checkFecthIndex(index);

    E result = data[index];

    if (index < size - 1) {
      System.arraycopy(data, index + 1, data, index, size - index - 1);
    }

    size--;
    return result;
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
  public E get(int index) {
    checkFecthIndex(index);
    return data[index];
  }

  private void checkFecthIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("invalid index: " + index);
    }
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
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < size;
      }

      @Override
      public E next() {
        return data[index++];
      }
    };
  }
}
