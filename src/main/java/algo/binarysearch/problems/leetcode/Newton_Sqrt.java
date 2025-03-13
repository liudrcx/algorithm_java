package algo.binarysearch.problems.leetcode;

/**
 * https://zh.wikipedia.org/zh-tw/%E7%89%9B%E9%A1%BF%E6%B3%95
 */
public class Newton_Sqrt {

  public static double exec_sqrt(int number, double epsilon) {
    if (number < 0) {
      throw new IllegalArgumentException("Invalid number: " + number);
    }

    double x = number;
    while (true) {
      double root = 0.5 * (x + number / x);
      if (Math.abs(root - x) < epsilon) {
        return root;
      }
      x = root;
    }
  }

  public static void main(String[] args) {
    System.out.println(exec_sqrt(2, 1e-1));
    System.out.println(exec_sqrt(2, 1e-4));
    System.out.println(exec_sqrt(2, 1e-5));
    System.out.println(exec_sqrt(2, 1e-6));
    System.out.println(exec_sqrt(2, 1e-7));
  }
}
