package liudrcx.ds.list.array;

import liudrcx.ds.list.DsList;

import java.util.Iterator;

public class DynamicArray<E> implements DsList<E> {

  private int size = 0;
  private int capacity;
  private E[] data;

  public DynamicArray(int capacity) {
    this.capacity = capacity;
    this.data = (E[]) new Object[capacity];
  }

  public DynamicArray() {
    this(8);
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
  public void add(int index, E e) {
    if (index < 0 || index > size) {
      throw invalidIndex(index);
    }

    checkAndExtendCapacity();

    if (index < size) {
      System.arraycopy(data, index, data, index + 1, size - index);
    }

    data[index] = e;
    size++;
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
  public E remove(int index) {
    if (index < 0 || index >= size) {
      throw invalidIndex(index);
    }

    E removedElement = data[index];

    if (index < size - 1) {
      System.arraycopy(data, index + 1, data, index, size - index - 1);
    }

    size--;
    return removedElement;
  }

  @Override
  public int removeByValue(E e) {
    int index = findByValue(e);
    if (index < 0) {
      return index;
    }
    remove(index);
    return index;
  }

  @Override
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw invalidIndex(index);
    }
    return data[index];
  }

  @Override
  public int findByValue(E e) {
    for (int i = 0; i < size; i++) {
      if (data[i].equals(e)) {
        return i;
      }
    }
    return -1;
  }

  private void checkAndExtendCapacity() {
    if (size == capacity) {
      capacity += capacity >> 1;
      E[] newData = (E[]) new Object[capacity];
      System.arraycopy(data, 0, newData, 0, size);
      this.data = newData;
    }
  }

  private IllegalArgumentException invalidIndex(int index) {
    return new IllegalArgumentException(String.format("Invalid index: %s", index));
  }

  @Override
  public int size() {
    return size;
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
