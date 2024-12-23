package algo.recursion;

public class Fibonacci {

  public static int exec(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    return exec(n - 1) + exec(n - 2);
  }
}
