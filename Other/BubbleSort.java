import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] number = { 1, 2, 3 };
        int[] result = bubbleSort(number);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public void test(int[] number) {
        bubbleSort(number);
    }

    private static int[] bubbleSort(int[] number) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(number, number.length);

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arr;
    }
}