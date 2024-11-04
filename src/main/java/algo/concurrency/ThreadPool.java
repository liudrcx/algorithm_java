package algo.concurrency;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Slf4j
public class ThreadPool {

  private int poolSize;

  private BlockingQueue<Runnable> queue;

  private List<WorkingThread> threads = new ArrayList<>();

  public ThreadPool(int poolSize, BlockingQueue<Runnable> queue) {
    this.poolSize = poolSize;
    this.queue = queue;
    for (int i = 0; i < poolSize; i++) {
      WorkingThread workingThread = new WorkingThread();
      workingThread.start();
      threads.add(workingThread);
    }
  }

  public void execute(Runnable runnable) {
    queue.offer(runnable);
  }

  class WorkingThread extends Thread {
    @Override
    public void run() {
      while (true) {
        try {
          Runnable runnable = queue.take();
          runnable.run();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  public static void main(String[] args) {
    ThreadPool pool = new ThreadPool(2, new LinkedBlockingQueue<>());
    pool.execute(() -> log.info("hello1"));
    pool.execute(() -> log.info("hello2"));

    log.info("main end");
  }
}
