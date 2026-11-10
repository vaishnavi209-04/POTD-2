class Solution {
    public int climbStairs(int n, int[] costs) {

        if(n==0)
        return 0;

        int[] dp=new int[n+1];

        for(int i=1;i<=n;i++)
            {
                int cost=costs[i-1];
                int prev=Integer.MAX_VALUE;

                if(i-1>=0)
                    prev=Math.min(prev,dp[i-1]+1);

                if(i-2>=0)
                    prev=Math.min(prev,dp[i-2]+4);

                if(i-3>=0)
                    prev=Math.min(prev,dp[i-3]+9);

                dp[i]=cost+prev;
            }
            
        return dp[n];
    }
}