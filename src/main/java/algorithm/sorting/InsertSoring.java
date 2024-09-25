package algorithm.sorting;

public class InsertSoring {

  public void sort(int[] arr) {
    if (arr == null || arr.length == 0) {
      return;
    }

    for(int i = 1; i < arr.length; i++) {
      int value = arr[i];
      int j = i - 1;
      for (; j >= 0; j--) {
        if (arr[j] > value) {
          arr[j + 1] = arr[j];
        } else {
          break;
        }
      }

      arr[j + 1] = value;
    }
  }
}
