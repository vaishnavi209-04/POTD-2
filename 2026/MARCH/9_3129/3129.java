//Approach 1-Recursion + Memoization-O(one * zero * limit)
class Solution {
    Integer[][][] dp;
    int mod=1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp=new Integer[zero+1][one+1][2];
        //start with 1 + start with 0
        return (solve(zero,one,1,limit) + solve(zero,one,0,limit)) % mod;
    }
    public int solve(int zero,int one,int last,int limit)
    {
        if(zero==0 && one==0)//no 0 or 1 left to add anymore we got 1 valid string
        return 1;

        if(dp[zero][one][last]!=null)
        return dp[zero][one][last];

        int res=0;

        if(last==1)//now explore 0s
        {
            for(int len=1;len<=Math.min(zero,limit);len++)//we can add only limit consecuitve 0 or 1 to keep condition 3 from getting violated
            {
                res=(res + solve(zero-len,one,0,limit)) % mod;
            }
        }
        else//explore 1s
        {
            for(int len=1;len<=Math.min(one,limit);len++)
            {
                res=(res + solve(zero,one-len,1,limit)) % mod;
            }
        }
        return dp[zero][one][last]=res;
    }
}
//Approach 2-Bottom Up-O(one * zero * limit)
class Solution {
    int mod=1_000_000_007;
    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp=new int[zero+1][one+1][2];
        //start with 1 + start with 0
        dp[0][0][0]=1;
        dp[0][0][1]=1;

        for(int zeroLeft=0;zeroLeft<=zero;zeroLeft++)
        {
            for(int oneLeft=0;oneLeft<=one;oneLeft++)
            {
                if(zeroLeft==0 && oneLeft==0)
                continue;
                
                int res=0;

                for(int len=1;len<=Math.min(zeroLeft,limit);len++)//we can add only limit consecuitve 0 or 1 to keep condition 3 from getting violated
                {
                    res=(res + dp[zeroLeft-len][oneLeft][0]) % mod;
                }
                dp[zeroLeft][oneLeft][1]=res;
                res=0;
                
                for(int len=1;len<=Math.min(oneLeft,limit);len++)
                {
                    res=(res + dp[zeroLeft][oneLeft-len][1]) % mod;
                }
                dp[zeroLeft][oneLeft][0]=res;
            }
        }

        return (dp[zero][one][0] + dp[zero][one][1]) % mod;
    }
}