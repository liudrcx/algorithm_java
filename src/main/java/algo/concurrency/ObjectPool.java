package algo.concurrency;

import algo.concurrency.util.Sleeper;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;
import java.util.function.Supplier;

import static algo.concurrency.util.Sleeper.sleep;

@Slf4j
public class ObjectPool<T, R> {

  private final List<T> data;

  private final Semaphore semaphore;

  public ObjectPool(int size, Supplier<T> supplier) {
    data = new Vector<>(size);
    for (int i = 0; i < size; i++) {
      data.add(supplier.get());
    }
    semaphore = new Semaphore(size);
  }

  public R exec(Function<T, R> function) throws InterruptedException {
    T t = null;
    try {
      semaphore.acquire();
      t = data.removeFirst();
      return function.apply(t);
    } finally {
      data.addLast(t);
      semaphore.release();
    }
  }

  public static void main(String[] args) {
    Random random = new Random();
    ObjectPool<Integer, Integer> pool = new ObjectPool<>(2, () -> random.nextInt());

    for (int i = 0; i < 3; i++) {
      new Thread(() -> {
        try {
          Integer result = pool.exec(number -> {
            sleep(1000);
            return number;
          });
          log.info("get result: {}", result);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }).start();
    }
  }
}
