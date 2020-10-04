import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class Tests {

    @Test
    public void simpleTests() {
        int[] arr1 = new int[]{4, 5, 1, 9, 0, 10, 3, 2, 7, 6, 8};
        int[] sortedArr1 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        HeapSort.heapsort(arr1, arr1.length);
        Assertions.assertArrayEquals(sortedArr1, arr1);
        int[] arr2 = new int[]{0, 0, 333, -333, 43532, 543, 1, 4, -432};
        int[] sortedArr2 = new int[]{-432, -333, 0, 0, 1, 4, 333, 543, 43532};
        HeapSort.heapsort(arr2, arr2.length);
        Assertions.assertArrayEquals(sortedArr2, arr2);
        int[] arr3 = new int[]{1, 2, 3, 4, 5};
        int[] sortedArr3 = new int[]{1, 2, 3, 4, 5};
        HeapSort.heapsort(arr3, arr3.length);
        Assertions.assertArrayEquals(sortedArr3, arr3);
        int[] emptyArray = new int[0];
        int[] emptyArraySorted = new int[0];
        HeapSort.heapsort(emptyArray, 0);
        Assertions.assertArrayEquals(emptyArray, emptyArraySorted);
        int[] arr = new int[]{-6, -2147483648, 2147483647, 0, -2147483648, 345, 2147483647};
        int[] sortedArr = new int[]{-2147483648, -2147483648, -6, 0, 345, 2147483647, 2147483647};
        HeapSort.heapsort(arr, arr.length);
        Assertions.assertArrayEquals(arr, sortedArr);
    }
}
