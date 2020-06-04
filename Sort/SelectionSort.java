public class SelectionSort {
    public static void main(String[] args) {
        int[] number = {4, 4, 3, 4, 6, 3, 54, 234, 1, 4};
        int[] result = selectionSort(number);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] selectionSort(int[] arr) {
        int min = 0;
        int index = 0;
        for (int j = 0; j < arr.length-1; j++) {
            min = arr[j];
            index = j;
            int temp = 0;
            for (int i = j+1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    index = i;
                }
            }

            temp = arr[j];
            arr[j] = min;
            arr[index] = temp;
        }
        
        return arr;
    }
}