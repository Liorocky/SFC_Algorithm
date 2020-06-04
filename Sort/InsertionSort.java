import java.util.LinkedList;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 3, 56, 3, 8, 98, 32 };
        LinkedList<Integer> sortList = insertionSort(arr);
        for (Integer integer : sortList) {
            System.out.println(integer);
        }
    }

    private static LinkedList<Integer> insertionSort(int[] arr) {
        LinkedList<Integer> sortList = new LinkedList<>();
        sortList.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            for (int j = sortList.size() - 1; j >= 0; j--) {
                if (arr[i] >= sortList.get(j)) {
                    sortList.add(j + 1, arr[i]);
                    break;
                } else if (j == 0) {
                    sortList.add(0, arr[i]);
                }
            }
        }

        return sortList;
    }
}