package algo.concurrency;

import algo.queue.Queue;

public class BlockingQueue<E> implements Queue<E> {


  @Override
  public int size() {
    return 0;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public boolean isEmpty() {
    return false;
  }

  @Override
  public void offer(E e) {

  }

  @Override
  public E poll() {
    return null;
  }

  @Override
  public E peek() {
    return null;
  }
}
