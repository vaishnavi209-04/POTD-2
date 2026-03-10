//Approach 1-Bottom up-O(zeo * one)
class Solution {
    int mod = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        int[][][] dp = new int[zero + 1][one + 1][2];

        // base cases
        for (int i = 1; i <= Math.min(zero, limit); i++)
            dp[i][0][0] = 1;//eg: [0], [0,0]....limit times

        for (int j = 1; j <= Math.min(one, limit); j++)
            dp[0][j][1] = 1;//eg: [1], [1,1]....limit times

        for (int i = 0; i <= zero; i++)
        {
            for (int j = 0; j <= one; j++)
            {

                if(i == 0 || j == 0)//we handled these cases in base case above
                    continue;

                // end with 0
                int val0 = (dp[i-1][j][0] + dp[i-1][j][1]) % mod;

                if (i-1 >= limit)
                    val0 = (val0 - dp[i-1-limit][j][1] + mod) % mod;

                dp[i][j][0] = val0;

                // end with 1
                int val1 = (dp[i][j-1][0] + dp[i][j-1][1]) % mod;

                if (j-1 >= limit)
                    val1 = (val1 - dp[i][j-1-limit][0] + mod) % mod;

                dp[i][j][1] = val1;
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}