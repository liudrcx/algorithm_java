package algo.concurrency;

import algo.queue.Queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue<E> implements Queue<E> {

  private List<E> data;

  private int capacity;

  public BlockingQueue(int capacity) {
    this.capacity = capacity;
    data = new ArrayList<>(capacity);
  }

  private final ReentrantLock lock = new ReentrantLock();

  private final Condition notFull = lock.newCondition();

  private final Condition notEmpty = lock.newCondition();

  @Override
  public int size() {
    return data.size();
  }

  @Override
  public boolean isFull() {
    return size() == capacity;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public void offer(E e) {
    try {
      lock.lock();

      while(isFull()) {
        try {
          notFull.await();
        } catch (InterruptedException ex) {
        }
      }

      data.add(e);
      notEmpty.signalAll();
    } finally {
      lock.unlock();
    }
  }

  @Override
  public E poll() {
    try {
      lock.lock();

      while(isEmpty()) {
        try {
          notEmpty.await();
        } catch (InterruptedException e) {
        }
      }

      E result = data.removeFirst();
      notFull.signalAll();
      return result;
    } finally {
      lock.unlock();
    }
  }

  @Override
  public E peek() {
    try {
      lock.lock();

      if (data.isEmpty()) {
        return null;
      }
      return data.get(0);
    } finally {
      lock.unlock();
    }
  }
}
