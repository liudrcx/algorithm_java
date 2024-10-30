package algo.concurrency.pattern;

import lombok.extern.slf4j.Slf4j;

import static algo.concurrency.Sleeper.sleep;

@Slf4j
public class GuardedSuspensionPattern {

  public static void main(String[] args) {
//    testGet();
    testGetWithTimeout();
  }

  private static void testGet() {
    FutureResponse<String> response = new FutureResponse<>();

    new Thread(() -> {
      log.info("get data: {}", response.get());
    }, "t1").start();

    sleep(1000);

    new Thread(() -> {
      response.set("hello world!");
    }, "t2").start();
  }

  private static void testGetWithTimeout() {
    FutureResponse<String> response = new FutureResponse<>();

    new Thread(() -> {
      log.info("get data: {}", response.get(1000));
    }, "t1").start();

    sleep(2000);

    new Thread(() -> {
      response.set("hello world!");
    }, "t2").start();
  }

  @Slf4j
  public static class FutureResponse<T> {
    T data;
    boolean hasData;

    final Object lock = new Object();

    public T get(long waitTime) {
      synchronized (lock) {
        long startTime = System.currentTimeMillis();
        long passedTime = 0L;

        while(!hasData) {
          long needWaitTime = waitTime - passedTime;
          if (needWaitTime <= 0) {
            log.info("time limitation catched, return");
            break;
          }

          try {
            log.info("waiting for data...");
            lock.wait(needWaitTime);
          } catch (InterruptedException e) {
            log.info("interupt", e);
          }

          passedTime = System.currentTimeMillis() - startTime;
        }

        return data;
      }
    }

    public T get() {
      synchronized (lock) {
        while(!hasData) {
          try {
            log.info("waiting for data...");
            lock.wait();
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }

        log.info("return data: {}", data);
        return data;
      }
    }

    public void set(T data) {
      synchronized (lock) {
        log.info("set data: {}", data);
        this.data = data;
        this.hasData = true;
        this.lock.notifyAll();
      }
    }
  }
}
