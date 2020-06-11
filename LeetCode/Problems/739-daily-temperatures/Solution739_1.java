class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        if (T.length <= 1) {
            return res;
        }

        for (int i = 0; i < res.length - 1; i++) {
            for (int j = i + 1; j < res.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }
}