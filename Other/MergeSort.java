import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = { 8, 4, 5, 7, 1, 3, 6, 2 };
        int[] tempArray = new int[a.length];
        mergeSort(a, tempArray, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    private static void mergeSort(int[] a, int[] tempArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tempArray, left, center);
            mergeSort(a, tempArray, center + 1, right);
            merge(a, tempArray, left, center + 1, right);
        }
    }

    public void test(int[] a) {
        int[] tempArray = new int[a.length];
        mergeSort(a, tempArray, 0, a.length - 1);
    }

    private static void merge(int[] a, int[] tempArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos] < a[rightPos]) {
                tempArray[tmpPos++] = a[leftPos++];
            } else {
                tempArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tempArray[tmpPos++] = a[leftPos++];
        }

        while (rightPos <= rightEnd) {
            tempArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tempArray[rightEnd];
        }
    }
}