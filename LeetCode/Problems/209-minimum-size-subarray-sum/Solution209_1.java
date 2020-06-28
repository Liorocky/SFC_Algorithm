class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) return 0;
        int left = 0, right = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int len = nums.length;
        boolean flag = false;

        while (left <= right && left < len) {
            while (right < len) {
                sum += nums[right];
                if (sum >= s) {
                    right++;
                    res = Math.min(right - left, res);
                    flag = true;
                    break;
                } else {
                    right++;
                }
            }

            while (left <= right && left < len) {
                sum -= nums[left];
                if (sum >= s) {
                    left++;
                    res = Math.min(right - left, res);
                } else {
                    left++;
                    break;
                }
            }
        }

        if (flag) return res;
        return 0;
    }
}