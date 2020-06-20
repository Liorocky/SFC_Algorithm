class Solution {
    public int[] exchange(int[] nums) {
        int[] res = new int[nums.length];
        int pre = 0;
        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                res[pre++] = nums[i];
            }

            if ((nums[i] & 1) == 0) {
                res[end--] = nums[i];
            }
        }

        return res;
    }
}