class Solution {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 7];

        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        dp[3]=2;
        dp[4]=4;
        dp[5]=6;
        dp[6]=9;

        if (n < 7) return dp[n];

        for (int i = 7; i <= n; i++) {
            dp[i] = dp[i - 3] * 3;
        }
        return dp[n];
    }
}