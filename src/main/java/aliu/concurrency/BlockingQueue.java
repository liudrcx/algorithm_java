package aliu.concurrency;

public interface BlockingQueue<E> {

  void offer(E value) throws InterruptedException;

  boolean offer(E value, long timeout) throws InterruptedException;

  E poll() throws InterruptedException;

  E poll(long timeout) throws InterruptedException;
}
