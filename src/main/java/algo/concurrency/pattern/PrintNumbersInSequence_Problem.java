package algo.concurrency.pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.LockSupport;

public class PrintNumbersInSequence_Problem {

  public static void main(String[] args) {
//    new Solution1().test();
    new Solution2().test();
  }

  @Slf4j
  static class Solution1 {

    private final Object lock = new Object();

    private boolean shouldPrint1 = false;

    public void test() {

      new Thread(() -> {
        synchronized (lock) {
          while(!shouldPrint1) {
            try {
              lock.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }

          System.out.print("1");
        }
      }, "t1").start();

      new Thread(() -> {
        synchronized (lock) {
          System.out.print("2");
          shouldPrint1 = true;
          lock.notifyAll();
        }
      }, "t2").start();
    }
  }

  @Slf4j
  static class Solution2 {

    public void test() {
      Thread t1;
      Thread t2;

      t1 = new Thread(() -> {
        LockSupport.park();
        System.out.printf("1");
      }, "t1");

      t2 = new Thread(() -> {
        System.out.printf("2");
        LockSupport.unpark(t1);
      }, "t2");

      t1.start();
      t2.start();
    }

  }
}
