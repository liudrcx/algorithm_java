package algo.concurrency.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import static algo.concurrency.util.Sleeper.sleep;

public class Balking_Pattern {

  public static void main(String[] args) {
    new Solution1().test();
  }

  @Slf4j
  static class Solution1 {

    public void test() {
      Executor executor = new Executor(() -> log.info("execute monitor..."));

      executor.start();
      executor.start();
      sleep(5000);
      executor.stop();
    }

    class Executor {

      private volatile boolean isStop = false;

      private boolean isStart = false;

      private Thread thread;

      private Runnable r;

      public Executor(Runnable r) {
        this.r = r;
      }

      public void start() {
        log.info("executor start");
        synchronized (this) {
          if (isStart) {
            log.info("executor has already been started");
            return;
          }

          isStart = true;
        }

        thread = new Thread(() -> {
          while(true) {
            if (isStop) {
              log.info("stop executor");
              break;
            }

            r.run();
            try {
              TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
              log.info("catching interruption", e);
            }
          }

        }, "t1");

        thread.start();
      }

      public void stop() {
        synchronized (this) {
          isStop = true;
          thread.interrupt();
          thread = null;
        }
      }
    }
  }
}
