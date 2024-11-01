package algo.concurrency.pattern;

import algo.concurrency.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import static algo.concurrency.Sleeper.sleep;

@Slf4j
public class TwoPhraseTermination_Pattern {

  public static void main(String[] args) throws InterruptedException {
//    new Solution1().test();
    new Solution2().test();
  }


  /**
   * using isInterrupted flag
   */
  public static class Solution1 {

    public void test() throws InterruptedException {
      Executor executor = new Executor(() -> log.info("executing monitor..."));
      executor.start();

      TimeUnit.SECONDS.sleep(5);
      executor.stop();
    }

    class Executor {

      Runnable r;

      Thread thread;

      public Executor(Runnable r) {
        this.r = r;
      }

      public void start() {
        log.info("start executor");

        thread = new Thread(() -> {
          while(true) {
            if (thread.isInterrupted()) {
              log.info("end executor");
              break;
            }

            try {
              r.run();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
              log.info("catching interruption", e);
              thread.interrupt();
            }
          }
        }, "executor-thread");
        thread.start();
      }

      public void stop() {
        log.info("end monitor");
        thread.interrupt();
        thread = null;
      }
    }

  }

  /**
   * using volatile variable flag
   */
  @Slf4j
  public static class Solution2 {

    public void test() {
      Executor executor = new Executor(() -> log.info("executing monitor"));

      executor.start();
      sleep(5000);
      executor.stop();
    }

    class Executor {

      private Thread thread;

      private Runnable r;

      private volatile boolean isStop = false;

      public Executor(Runnable r) {
        this.r = r;
      }

      public void start() {
        log.info("start executor");

        thread = new Thread(() -> {
          while(true) {
            if (isStop) {
              log.info("end executor");
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
        log.info("end executor");
        isStop = true;
        thread.interrupt();
      }
    }
  }
}
