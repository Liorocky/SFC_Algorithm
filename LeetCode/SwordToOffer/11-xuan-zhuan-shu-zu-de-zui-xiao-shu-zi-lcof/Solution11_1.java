class Solution {
    public int minArray(int[] numbers) {
        int i = 0, j = numbers.length - 1;
        int m = 0;

        while (i < j) {
            m = (i + j) / 2;
            if (numbers[m] > numbers[j]) {
                i = m + 1;
            } else if (numbers[m] < numbers[j]) {
                j = m;
            } else {
                j--;
            }
        }

        return numbers[i];
    }
}