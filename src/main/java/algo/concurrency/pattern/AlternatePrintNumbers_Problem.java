package algo.concurrency.pattern;

import algo.concurrency.Sleeper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import static algo.concurrency.Sleeper.sleep;

/**
 * print 123 in 5 loop
 */
public class AlternatePrintNumbers_Problem {

  public static void main(String[] args) {
//    new Solution1().test();
//    new Solution2().test();
    new Solution3().test();
  }

  static class Solution1 {

    public void test() {
      NumberPrinter printer = new NumberPrinter(1, 5);

      Thread t1 = new Thread(() -> {
        printer.print(1, 2, 1);
      }, "t1");

      Thread t2 = new Thread(() -> {
        printer.print(2, 3, 2);
      }, "t2");

      Thread t3 = new Thread(() -> {
        printer.print(3, 1, 3);
      }, "t3");

      t1.start();
      t2.start();
      t3.start();
    }

    class NumberPrinter {

      private int flag;

      private int loopNumber;

      public NumberPrinter(int flag, int loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
      }

      public void print(int waitFlag, int nextFlag, int printNumber) {
        for (int i = 0; i < loopNumber; i++) {
          synchronized (this) {
            while (flag != waitFlag) {
              try {
                wait();
              } catch (InterruptedException e) {
                throw new RuntimeException(e);
              }
            }

            System.out.print(printNumber);
            flag = nextFlag;
            notifyAll();
          }
        }
      }
    }
  }

  static class Solution2 {

    public void test() {
      NumberPrinter printer = new NumberPrinter(5);
      Condition printOne = printer.newCondition();
      Condition printTwo = printer.newCondition();
      Condition printThree = printer.newCondition();

      Thread t1 = new Thread(() -> {
        printer.print(printOne, printTwo, 1);
      }, "t1");

      Thread t2 = new Thread(() -> {
        printer.print(printTwo, printThree, 2);
      }, "t2");

      Thread t3 = new Thread(() -> {
        printer.print(printThree, printOne, 3);
      }, "t3");

      t1.start();
      t2.start();
      t3.start();

      sleep(500);
      try {
        printer.lock();
        printOne.signalAll();
      } finally {
        printer.unlock();
      }
    }

    class NumberPrinter extends ReentrantLock{

      private int loopNumber;

      public NumberPrinter(int loopNumber) {
        this.loopNumber = loopNumber;
      }

      public void print(Condition current, Condition next, int printNumber) {
        for (int i = 0; i < loopNumber; i++) {
          try {
            lock();
            try {
              current.await();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }

            System.out.print(printNumber);

            next.signalAll();
          } finally {
            unlock();
          }
        }
      }
    }
  }

  static class Solution3 {

    public void test() {
      NumberPrinter printer = new NumberPrinter(5);

      Thread t1 = new Thread(() -> {
        printer.print(1, 2);
      }, "t1");

      Thread t2 = new Thread(() -> {
        printer.print(2, 3);
      }, "t2");

      Thread t3 = new Thread(() -> {
        printer.print(3, 1);
      }, "t3");

      printer.addThreads(t1, t2, t3);

      t1.start();
      t2.start();
      t3.start();

      sleep(500);
      LockSupport.unpark(t1);
    }

    class NumberPrinter {

      private int loopNumber;

      private List<Thread> threads;

      public NumberPrinter(int loopNumber) {
        this.loopNumber = loopNumber;
        threads = new ArrayList<>();
      }

      public void addThreads(Thread... threads) {
        this.threads.addAll(List.of(threads));
      }

      public void print(int printNumnber, int nextThreadNumber) {
        for (int i = 0; i < loopNumber; i++) {
          LockSupport.park();

          System.out.print(printNumnber);

          LockSupport.unpark(threads.get(nextThreadNumber - 1));
        }
      }
    }

  }
}
