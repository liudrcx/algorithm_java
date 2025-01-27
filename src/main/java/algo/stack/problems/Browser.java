package algo.stack.problems;


import java.util.Stack;

public class Browser {

  Stack<String> stack1 = new Stack<>();
  Stack<String> stack2 = new Stack<>();

  public String open(String page) {
    stack1.push(page);
    stack2.clear();
    return page;
  }

  public String back() {
    String page = stack1.pop();
    stack2.push(page);
    return page;
  }

  public String forward() {
    String page = stack2.pop();
    stack1.push(page);
    return page;
  }
}
