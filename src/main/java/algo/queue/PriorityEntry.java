package algo.queue;

public class PriorityEntry implements Priority{

  private String name;
  private int priority;

  public PriorityEntry(String name, int priority) {
    this.name = name;
    this.priority = priority;
  }


  @Override
  public int priority() {
    return priority;
  }

  @Override
  public String toString() {
    return "PriorityEntry{" +
      "name='" + name + '\'' +
      ", priority=" + priority +
      '}';
  }
}
