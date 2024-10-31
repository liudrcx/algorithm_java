package algo.concurrency.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class TwoPhraseTermination_Pattern {

  public static void main(String[] args) throws InterruptedException {
    new Solution1().test();
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
}
