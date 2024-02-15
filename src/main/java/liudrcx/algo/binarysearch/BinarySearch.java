package liudrcx.algo.binarysearch;

public class BinarySearch {

  public static int binarySearchBasic(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m - 1;
      } else if (arr[m] < target) {
        i = m + 1;
      } else {
        return m;
      }
    }
    return -1;
  }

  public static int binarySearchRecursion(int[] arr, int target) {
    return binarySearchRecursion(arr, target, 0, arr.length - 1);
  }

  private static int binarySearchRecursion(int[] arr, int target, int i, int j) {
    if (i > j) {
      return -1;
    }

    int m = (i + j) >>> 1;
    if (target < arr[m]) {
      return binarySearchRecursion(arr, target, i, m - 1);
    } else if (arr[m] < target) {
      return binarySearchRecursion(arr, target, m + 1, j);
    } else {
      return m;
    }
  }


  /**
   * <h3>二分查找改动版</h3>
   *
   * <ol>
   *     <li>i, m 指针可能是查找目标</li>
   *     <li>j 指针不可能是查找目标</li>
   *     <li>因为 1. 2. i >= j 时表示区域内没有要找的了</li>
   *     <li>改变 i 边界时, m 已经比较过不是目标, 因此需要 i=m+1</li>
   *     <li>改变 j 边界时, m 已经比较过不是目标, 同时因为 2. 所以 j=m</li>
   * </ol>
   *
   * @param arr      待查找的升序数组
   * @param target 待查找的目标值
   * @return <p>找到则返回索引</p>
   * <p>找不到返回 -1</p>
   */
  public static int binarySearchAlternative(int[] arr, int target) {
    int i = 0, j = arr.length;
    while(i < j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m;
      } else if (arr[m] < target) {
        i = m + 1;
      } else {
        return m;
      }
    }
    return -1;
  }

  /**
   * <h3>二分查找平衡版</h3>
   *
   * <ol>
   *     <li>不奢望循环内通过 m 找出目标, 缩小区间直至剩 1 个, 剩下的这个可能就是要找的(通过 i)</li>
   *     <li>i 指针可能是查找目标</li>
   *     <li>j 指针不可能是查找目标</li>
   *     <li>因为 1. 2. 3. 当区域内还剩一个元素时, 表示为 j - i == 1</li>
   *     <li>改变 i 边界时, m 可能就是目标, 同时因为 2. 所以有 i=m</li>
   *     <li>改变 j 边界时, m 已经比较过不是目标, 同时因为 3. 所以有 j=m</li>
   *     <li>三分支改为二分支, 循环内比较次数减少</li>
   * </ol>
   *
   * @param arr      待查找的升序数组
   * @param target 待查找的目标值
   * @return <p>找到则返回索引</p>
   * <p>找不到返回 -1</p>
   */
  public static int binarySearchBalance(int[] arr, int target) {
    int i = 0, j = arr.length;
    while(j - i > 1) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m;
      } else {
        i = m;
      }
    }

    if (arr[i] == target) {
      return i;
    }

    return -1;
  }

  /**
   * <h3>二分查找 Leftmost </h3>
   *
   * @param arr      待查找的升序数组
   * @param target 待查找的目标值
   * @return <p>找到则返回最靠左索引</p>
   * <p>找不到返回 -1</p>
   */
  public static int binarySearchLeftmost1(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    int candidate = -1;
    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m - 1;
      } else if (arr[m] < target) {
        i = m + 1;
      } else {
        j = m - 1;
        candidate = m;
      }
    }
    return candidate;
  }

  /**
   * <h3>二分查找 Rightmost </h3>
   *
   * @param arr      待查找的升序数组
   * @param target 待查找的目标值
   * @return <p>找到则返回最靠右索引</p>
   * <p>找不到返回 -1</p>
   */
  public static int binarySearchRightmost1(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    int candidate = -1;
    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target < arr[m]) {
        j = m - 1;
      } else if (arr[m] < target) {
        i = m + 1;
      } else {
        i = m + 1;
        candidate = m;
      }
    }
    return candidate;
  }

  /**
   * <h3>二分查找 Leftmost </h3>
   *
   * @param arr      待查找的升序数组
   * @param target 待查找的目标值
   * @return <p>返回 &ge; target 的最靠左索引</p>
   */
  public static int binarySearchLeftmost2(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    while(i <= j) {
      int m = (i + j) >>> 1;
      if (target <= arr[m]) {
        j = m - 1;
      } else {
        i = m + 1;
      }
    }
    return i;
  }

  /**
   * <h3>二分查找 Rightmost </h3>
   *
   * @param arr      待查找的升序数组
   * @param target 待查找的目标值
   * @return <p>返回 &le; target 的最靠右索引</p>
   */
  public static int binarySearchRightmost2(int[] arr, int target) {
    int i = 0, j = arr.length - 1;
    while(i <= j) {
      int m = (i + j) >>> 1;
      if (arr[m] <= target) {
        i = m + 1;
      } else {
        j = m - 1;
      }
    }
    return i - 1;
  }
}
