// 动态规划  备忘录法
class Solution {
    HashMap<Integer, Integer> map;

    public int tribonacci(int n) {
        map = new HashMap<>();
        return recur(n);
    }

    private int recur(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int value = recur(n - 3) + recur(n - 2) + recur(n - 1);
        map.put(n, value);
        return value;
    }