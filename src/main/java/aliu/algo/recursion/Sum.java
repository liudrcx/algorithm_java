package aliu.algo.recursion;

public class Sum {

  // sum = 1 + 2 + 3 ... + n
  public static int exec(int n) {
    if (n == 1) {
      return 1;
    }

    return n + exec(n - 1);
  }
}
