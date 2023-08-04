package liudrcx.algo.array;

import java.util.Arrays;
import java.util.stream.Stream;

public class DynamicArray<T> {

  private T[] data;
  private int size = 0;
  private int capacity = 0;

  public DynamicArray() {
    this(10);
  }

  public DynamicArray(int capacity) {
    this.capacity = capacity;
    this.data = (T[]) new Object[capacity];
  }

  public void add(int index, T e) {
    if (index < 0 || index > size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    if (size == capacity) {
      expandArray();
    }

    if (index < size) {
      System.arraycopy(data, index, data, index + 1, size - index);
    }

    data[index] = e;
    size++;
  }

  private void expandArray() {
    capacity += capacity >>> 1;
    T[] newData = (T[]) new Object[capacity];
    System.arraycopy(data, 0, newData, 0, size);
    data = newData;
  }

  public void addFirst(T e) {
    add(0, e);
  }

  public void addLast(T e) {
    add(size, e);
  }

  public T get(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }
    return data[index];
  }

  public T remove(int index) {
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException("Invalid index: " + index);
    }

    T e = data[index];
    if (index < size - 1) {
      System.arraycopy(data, index + 1, data, index, size - index - 1);
    }
    size--;
    return e;
  }

  public int size() {
    return size;
  }

  public Stream<T> stream() {
    return Arrays.stream(dataArrays.copyOfRange(data, 0, size));
  }

}
