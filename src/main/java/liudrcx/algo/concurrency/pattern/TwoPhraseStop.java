package liudrcx.algo.concurrency.pattern;

import lombok.extern.slf4j.Slf4j;


@Slf4j(topic = "c.TwoPhraseStop")
public class TwoPhraseStop {

  public static void main(String[] args) throws InterruptedException {
    MonitorThread t = new MonitorThread();
    t.start();

    Thread.sleep(3000);
    t.stop();
  }

  @Slf4j(topic = "c.MonitorThread")
  static class MonitorThread {

    private Thread thread;
    private volatile boolean stop = false;

    public void start() {
      thread = new Thread(() -> {
        while (true) {
          if (stop) {
            log.info("stop monitor, clean env...");
            break;
          }

          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
          }

          log.info("executing monitor...");
        }
      }, "monitor");

      thread.start();
    }

    public void stop() {
      stop = true;
      thread.interrupt();
    }
  }
}
