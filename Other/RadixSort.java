import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 53, 3, 542, 748, 14, 214 };
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {
        // 1.先找到数组中最大数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = max > arr[i] ? max : arr[i];
        }
        int maxLength = (max + "").length();

        // 2.建立十个桶，每个桶的大小都为数组长度
        int[][] bucket = new int[10][arr.length];

        // 3.建立一个长度为10的一维数组，保存每个桶中的元素数量
        int[] bucketElementsCounts = new int[10];

        // 4.将数组中的所有数据依次放入桶中
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int radix = arr[j] / n % 10;
                bucket[radix][bucketElementsCounts[radix]++] = arr[j];
            }

            // 5.将排序好的桶中的数据，转移到数组arr中
            int index = 0;
            for (int k = 0; k < 10; k++) {
                for (int m = 0; m < bucketElementsCounts[k]; m++) {
                    arr[index++] = bucket[k][m];
                }

                bucketElementsCounts[k] = 0;
            }
        }
    }

    public void test(int[] arr) {
        radixSort(arr);
    }
}