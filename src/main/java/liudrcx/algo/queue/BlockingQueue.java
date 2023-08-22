package liudrcx.algo.queue;

public interface BlockingQueue<E> {

  void offer(E value) throws InterruptedException;

  E poll() throws InterruptedException;
}
