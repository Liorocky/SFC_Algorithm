class Solution {
    public int removeDuplicates(int[] nums) {
        int cur = 1; // 快指针
        int i = 1; // 慢指针，表示新数组的大小

        for (; i < nums.length; i++) {
            if (cur == nums.length) {
                return i; // 当快指针遍历完成之后，直接返回i
            }

            /*
            快指针与慢指针-1的元素判断是否重复，如果重复，快指针后移
            如果快指针移动到了数组末尾，说明新数组后面的元素都是重复的，则直接返回i即可
             */
            while (nums[cur] == nums[i - 1]) {
                if (++cur == nums.length) {
                    return i;
                }
            }

            // 说明cur是重复元素后的第一个不重复元素，添加到新数组中
            nums[i] = nums[cur++];
        }

        return i;
    }
}