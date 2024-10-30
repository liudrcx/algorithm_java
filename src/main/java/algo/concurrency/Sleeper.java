package algo.concurrency;

import java.util.concurrent.TimeUnit;

public class Sleeper {

  public static void sleep(int ms) {
    try {
      TimeUnit.MILLISECONDS.sleep(ms);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
