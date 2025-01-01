package algo.greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static algo.greedy.Activity_Selection_Problem.*;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class Activity_Selection_Problem_Test {

  @Test
  public void testSelection() {
    List<Activity> activityList = new ArrayList<>();
    activityList.add(new Activity(0, 2, 4));
    activityList.add(new Activity(1, 1, 3));
    activityList.add(new Activity(2, 3, 5));

    List<Activity> result = select(activityList);

    assertIterableEquals(result, List.of(
      new Activity(1, 1, 3),
      new Activity(2, 3, 5)
    ));
  }
}
