package liudrcx.algo.recursion;

import java.util.LinkedList;

public class HanoiTower {

  static LinkedList<Integer> a = new LinkedList<>();
  static LinkedList<Integer> b = new LinkedList<>();
  static LinkedList<Integer> c = new LinkedList<>();

  static void init(int n) {
    for(int i = n; i >= 1; i--) {
      a.add(i);
    }
  }

  static void mv(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
    if (n == 0) {
      return;
    }

    mv(n - 1, a, c, b);
    c.addLast(a.removeLast());
    print();
    mv(n - 1, b, a, c);
  }

  static void print() {
    System.out.println("-----------------------");
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
  }

  public static void main(String[] args) {
    init(3);
    print();
    mv(3, a, b, c);
  }

}
