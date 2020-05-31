public class BubbleSort {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int[] result = bubbleSort(number);
        for (int i : result) {
            System.out.println(i);
        }
    }

    private static int[] bubbleSort(int[] number) {
        int count = 0;

        for (int i = number.length; i > 0; i--) {
            int c = number.length-i+1;
            count = 0;
            System.out.println("第" + c + "次换位了" + count + "次");
            if (count == 0) {
                break;
            }
        }
        
        return number;
    }
}