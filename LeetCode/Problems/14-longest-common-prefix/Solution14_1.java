class Solution {
    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length < 1) {
            return res;
        }
        int n = strs[0].length();
        boolean flag = false;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].startsWith(strs[0].substring(0, i))) {
                    flag = true;
                } else {
                    return strs[0].substring(0, i - 1);
                }
            }

            if (flag) {
                res = strs[0].substring(0, i);
            }
        }

        return res;
    }
}