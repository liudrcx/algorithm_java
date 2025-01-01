package algo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * given a list of activites, make the meeting room takes largest number of activies without time overlap
 */
public class Activity_Selection_Problem {

  public static List<Activity> select(List<Activity> activityList) {
    Collections.sort(activityList, Comparator.comparingInt(Activity::getEnd));

    List<Activity> result = new ArrayList<>();
    Activity prev = activityList.get(0);
    result.add(prev);

    for (int i = 1; i < activityList.size(); i++) {
      Activity current = activityList.get(i);
      if (prev.end <= current.start) {
        result.add(current);
        prev = current;
      }
    }

    return result;
  }


  public static class Activity {

    private int index;

    private int start;

    private int end;

    public Activity(int index, int start, int end) {
      this.index = index;
      this.start = start;
      this.end = end;
    }

    public int getIndex() {
      return index;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Activity activity = (Activity) o;
      return index == activity.index && start == activity.start && end == activity.end;
    }

    @Override
    public int hashCode() {
      return Objects.hash(index, start, end);
    }
  }
}
