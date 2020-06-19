class Solution {
    public int cuttingRope(int n) {
        long[] dp = new long[n + 7];

        dp[0]=0;
        dp[1]=0;
        dp[2]=1;
        dp[3]=2;
        dp[4]=4;
        dp[5]=6;
        dp[6]=9;

        if (n < 7) return (int) dp[n] % 1000000007;

        for (int i = 7; i <= n; i++) {
            dp[i] = (dp[i - 3] * 3) % 1000000007;
        }

        return (int) dp[n];
    }
}