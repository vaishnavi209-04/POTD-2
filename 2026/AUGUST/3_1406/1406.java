//Approach 1:Recursion + Memoization -O(n)
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        Integer[] dp=new Integer[n];
        int res=solve(0,n,stoneValue,dp);
        if(res>0)
        return "Alice";
        else if(res<0)
        return "Bob";
        else
        return "Tie";
    }
    public int solve(int i,int n,int[] stones,Integer[] dp)
    {
        if(i==n)
        return 0;

        if(dp[i]!=null)
        return dp[i];

        int res=stones[i]-solve(i+1,n,stones,dp);//take 1 pile
        if(i+1<n)
        {
            res=Math.max(res,stones[i]+stones[i+1]-solve(i+2,n,stones,dp));//take 2 pile
        }

        if(i+2<n)
        {
            res=Math.max(res,stones[i]+stones[i+1]+stones[i+2]-solve(i+3,n,stones,dp));//take 3 pile
        }

        return dp[i]=res;
    }
}
//Approach 2-Bottom up-O(n)
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        int[] dp=new int[n+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--)
        {
            dp[i]=Integer.MIN_VALUE;
            int sum=0;
            for(int k=0;k<3 && i+k<n;k++)
            {
                sum+=stoneValue[i+k];
                dp[i]=Math.max(dp[i],sum-dp[i+k+1]);

            }
        }
        if(dp[0]>0)
        return "Alice";
        else if(dp[0]<0)
        return "Bob";
        else
        return "Tie";
    }
}