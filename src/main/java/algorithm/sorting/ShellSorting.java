package algorithm.sorting;

public class ShellSorting {

  public void sort(int[] arr) {
    if (arr == null || arr.length == 0 || arr.length == 1) {
      return;
    }

    int step = arr.length / 2;
    while(step >= 1) {
      for(int i = step; i < arr.length; i++) {
        int value = arr[i];
        int j = i - step;
        for(;j >= 0; j -= step) {
          if (arr[j] > value) {
            arr[j + step] = arr[j];
          } else {
            break;
          }
        }
        arr[j + step] = value;
      }
      step = step / 2;
    }
  }
}
