class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();

        int len = (int) Math.pow(2, nums.length);

        for (int i = 0; i < len; i++) {
            List<Integer> tmp = new ArrayList<>();
            StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
            while (sb.length() != nums.length) {
                sb.insert(0, '0');
            }

            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) != '0') {
                    tmp.add(nums[j]);
                }
            }
            ls.add(tmp);
        }

        return ls;
    }
}