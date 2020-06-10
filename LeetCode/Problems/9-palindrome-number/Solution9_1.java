public class Solution9_1 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String str = x + "";
        for (int i = 0, j = str.length() - 1; i < str.length(); i++, j--) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }

        return true;
    }
}
