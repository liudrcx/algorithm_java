package liudrcx.algo.queue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<E> implements BlockingQueue<E> {

  private E[] data;
  private int size = 0;
  private int head = 0;
  private int tail = 0;

  private ReentrantLock lock = new ReentrantLock();
  private Condition tailWaits = lock.newCondition();
  private Condition headWaits = lock.newCondition();

  public ArrayBlockingQueue(int capacity) {
    this.data = (E[]) new Object[capacity + 1];
  }

  @Override
  public void offer(E value) throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (isFull()) {
        tailWaits.await();
      }

      data[tail] = value;
      tail = (tail + 1) % this.data.length;
      size++;
      headWaits.signalAll();
    } finally{
      lock.unlock();
    }
  }

  @Override
  public E poll() throws InterruptedException {
    lock.lockInterruptibly();
    try {
      while (isEmpty()) {
        headWaits.await();
      }

      E value = data[head];
      data[head] = null; //for GC
      head = (head + 1) % this.data.length;
      size--;
      tailWaits.signalAll();
      return value;
    } finally{
      lock.unlock();
    }
  }

  private boolean isEmpty() {
    return head == tail;
  }

  private boolean isFull() {
    return (tail + 1) % this.data.length == head;
  }

  @Override
  public String toString() {
    return Arrays.toString(data);
  }

  public static void main(String[] args) throws InterruptedException {
    BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);
    new Thread(()->{
      try {
        System.out.println(queue.poll());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, "poll").start();

    TimeUnit.SECONDS.sleep(1);
    queue.offer("task1");

    new Thread(()->{
      try {
        queue.offer("task2");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }, "offer").start();
  }
}
