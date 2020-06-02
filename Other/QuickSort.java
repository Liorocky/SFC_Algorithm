public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 0, -1, 32, 56, 0 ,34, 21};

        quickSort(arr, 0, arr.length -1);
        printArr(arr);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            int key = arr[l];
            int i = l;
            int j = r;

            while (i < j) {
                while (arr[j] >= key && i < j) {
                    j--;
                }
                if (i < j) {
                    arr[i++] = arr[j];
                }
                
                while (arr[i] <= key && i < j) {
                    i++;
                }
                if (i < j) {
                    arr[j--] = arr[i];
                }
            }

            arr[i] = key;

            quickSort(arr, 0, i - 1);
            quickSort(arr, i + 1, r);
        }       
    }

    private static void printArr(int[] arr) {
        System.out.println("---------");
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("---------");
    }
}