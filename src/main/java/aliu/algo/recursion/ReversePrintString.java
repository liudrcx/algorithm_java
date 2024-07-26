package aliu.algo.recursion;

public class ReversePrintString {

  public static void print(String str) {
    print(0, str);
  }

  private static void print(int i, String str) {
    if (i == str.length()) {
      return;
    }

    print(i + 1, str);
    System.out.println(str.charAt(i));
  }

  public static void main(String[] args){
    print("hello");
  }
}
